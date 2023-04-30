package com.example.punkapi.api.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.api.repo.Resource
import com.example.punkapi.models.Beer

const val STARTING_PAGE_INDEX = 1

class PagingDataSource(private val repo: RepositoryContract): PagingSource<Int, Beer>() {

    override fun getRefreshKey(state: PagingState<Int, Beer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Beer> {
        val position = params.key ?: STARTING_PAGE_INDEX

        //Retrofit will automatically make suspend functions main-safe so you can call them directly from Dispatchers.Main
        return when (val result = repo.getBeers(position, params.loadSize)) {

            is Resource.Error -> LoadResult.Error(Exception(result.error.toString()))
            is Resource.Success -> {
                LoadResult.Page(
                    data = result.data as List<Beer>,
                    prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                    nextKey = if (result.data.isEmpty()) null else position + 1
                )
            }
        }
    }
}