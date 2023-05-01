package com.example.punkapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.punkapi.api.datasource.PagingDataSource
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.models.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class BeersViewModel @Inject constructor(
    repo: RepositoryContract
) : ViewModel() {

    private val searchFlow: MutableStateFlow<String> = MutableStateFlow("")

    /**
     * flow a new Pager everytime the searchFlow emit a new search
     */
    private val _beerFlow: Flow<PagingData<Beer>> = searchFlow.flatMapLatest { search ->
        Pager(
            config = PagingConfig(
                pageSize = 25,
                initialLoadSize = 25,
            ),
            pagingSourceFactory = {
                PagingDataSource(repo, search)
            }
        ).flow
    }.cachedIn(viewModelScope)

    val beerFlow: Flow<PagingData<Beer>>
        get() = _beerFlow

    fun searchBeer(text: String) {
        viewModelScope.launch {
            searchFlow.value = text
        }
    }
}