package com.example.punkapi.api.repo

import com.example.punkapi.models.Beer
import kotlinx.coroutines.flow.Flow

interface RepositoryContract {
    fun getBeers(): Flow<Resource<List<Beer>>>
}
