package com.example.punkapi.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.api.repo.Resource
import com.example.punkapi.models.BeerDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    private val repo: RepositoryContract,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val beerId: Int = checkNotNull(savedStateHandle["beerId"])

    private val _beerState = MutableStateFlow<Resource<BeerDetail>?>(null)
    val beerState: StateFlow<Resource<BeerDetail>?> = _beerState

    init {
        viewModelScope.launch {
            val beer = repo.getBeer(beerId)
            _beerState.value = beer
        }
    }
}
