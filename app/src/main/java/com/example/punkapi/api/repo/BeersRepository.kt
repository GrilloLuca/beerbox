package com.example.punkapi.api.repo

import com.example.punkapi.api.PunkApi
import com.example.punkapi.models.Beer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class BeersRepository @Inject constructor(private val api: PunkApi): RepositoryContract {

    override suspend fun getBeers(page: Int, size: Int): Resource<List<Beer>> {

        val response = api.getBeers(
            page = page,
            per_page = size
        )

        return if(response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error(response.errorBody())
        }
    }
}