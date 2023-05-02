package com.example.punkapi.ui.viewmodel

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
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class BeersViewModel @Inject constructor(
    repo: RepositoryContract
) : ViewModel() {

    private val searchText = MutableStateFlow("")
    private val filterText = MutableStateFlow("")

    /**
     * Combine 2 flow for search and filter inputs.
     * Flow a new Pager everytime the combined flow emit a new search
     */
    private val _beerFlow: Flow<PagingData<Beer>> = searchText
        .combine(filterText) { search, filter -> "$search $filter" }
        .flatMapLatest { search ->
            Pager(
                config = PagingConfig(
                    pageSize = PAGE_SIZE,
                    initialLoadSize = PAGE_SIZE,
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
            searchText.value = text
        }
    }

    fun filterBeers(text: String) {
        viewModelScope.launch {
            filterText.value = text
        }
    }

    companion object {
        const val PAGE_SIZE: Int = 25
    }
}