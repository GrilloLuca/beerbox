package com.example.punkapi.api.repo

import com.example.punkapi.models.Beer

interface RepositoryContract {
    suspend fun getBeers(page: Int, size: Int, beerName: String): Resource<List<Beer>>
}
