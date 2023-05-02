package com.example.punkapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.punkapi.api.usecase.GetBeerPageUseCase
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
    useCase: GetBeerPageUseCase
) : ViewModel() {

    private val searchText = MutableStateFlow("")
    private val filterText = MutableStateFlow("")

    /**
     * Following the Clean Architecture design pattern, UseCases helps to separate business logic and makes the app more testable.
     * The GetBeerPageUseCase has been injected from hilt in the ViewModel
     *
     * Combine 2 flow for search and filter inputs and executing the UseCase with the result.
     * Flow a new Pager everytime the combined flow emit a new search
     */
    private val _beerFlow: Flow<PagingData<Beer>> =
        searchText.combine(filterText) { search, filter ->
            "$search $filter"
        }.flatMapLatest { search ->
            useCase.execute(search)
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

}