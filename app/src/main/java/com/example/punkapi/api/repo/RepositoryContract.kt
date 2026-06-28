package com.example.punkapi.api.repo

import com.example.punkapi.models.Beer
import com.example.punkapi.models.BeerDetail

interface RepositoryContract {
    suspend fun getBeers(page: Int, size: Int, beerName: String): Resource<List<Beer>>
    suspend fun getBeer(id: Int): Resource<BeerDetail>
}
