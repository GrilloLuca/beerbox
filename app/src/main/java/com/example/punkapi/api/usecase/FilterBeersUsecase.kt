package com.example.punkapi.api.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.punkapi.api.datasource.PagingDataSource
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.models.Beer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBeerPageUseCase @Inject constructor(private val repo: RepositoryContract) {

    fun execute(search: String): Flow<PagingData<Beer>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                PagingDataSource(repo, search)
            }
        ).flow
    }

    companion object {
        const val PAGE_SIZE: Int = 25
    }

}