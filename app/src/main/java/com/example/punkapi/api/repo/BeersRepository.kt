package com.example.punkapi.api.repo

import com.example.punkapi.api.PunkApi
import com.example.punkapi.models.Beer
import javax.inject.Inject

class BeersRepository @Inject constructor(private val api: PunkApi): RepositoryContract {

    override suspend fun getBeers(page: Int, size: Int, beerName: String): Resource<List<Beer>> {

        val response = api.getBeers(
            page = page,
            perPage = size,
            beerName = beerName.ifEmpty { null }
        )

        return if(response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error(response.errorBody())
        }
    }
}