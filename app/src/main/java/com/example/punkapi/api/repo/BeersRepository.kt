package com.example.punkapi.api.repo

import com.example.punkapi.api.PunkApi
import com.example.punkapi.models.Beer
import javax.inject.Inject

class BeersRepository @Inject constructor(private val api: PunkApi): RepositoryContract {

    override suspend fun getBeers(page: Int, size: Int, beerName: String): Resource<List<Beer>> {
        return kotlin.runCatching {
            api.getBeers(
                page = page,
                perPage = size,
                beerName = beerName.ifEmpty { null }
            )
        }.fold(
            onSuccess = {
                if(it.isSuccessful) {
                    Resource.Success(it.body())
                } else {
                    Resource.Error(it.errorBody().toString())
                }
            },
            onFailure = {
                Resource.Error("")
            }
        )
    }
}