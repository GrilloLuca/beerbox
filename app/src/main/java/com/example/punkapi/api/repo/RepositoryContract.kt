package com.example.punkapi.api.repo

import com.example.punkapi.models.Beer
import retrofit2.Response

interface RepositoryContract {
    suspend fun getBeers(page: Int, size: Int): Resource<List<Beer>>
}
