package com.example.punkapi.api.repo

import com.example.punkapi.api.PunkApi
import com.example.punkapi.models.Beer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BeersRepository @Inject constructor(private val api: PunkApi): RepositoryContract {


    override fun getBeers(): Flow<Resource<List<Beer>>> = flow {

        val response = api.getBeers(
            page = 1,
            per_page = 25
        )

        if(response.isSuccessful) {
            emit(Resource.Success(response.body()))
        } else {
            emit(Resource.Error(response.errorBody()))
        }
    }
}