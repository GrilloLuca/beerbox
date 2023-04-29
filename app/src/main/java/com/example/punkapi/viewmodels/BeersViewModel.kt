package com.example.punkapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.punkapi.api.PunkApi
import com.example.punkapi.models.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    private val api: PunkApi
) : ViewModel() {

    val beers: MutableLiveData<List<Beer>> = MutableLiveData()

    init {
        viewModelScope.launch {
            getBeers()
        }
    }

    private suspend fun getBeers() {
        withContext(Dispatchers.IO) {

            val randomBeer = api.randomBeer(
                page = 1,
                per_page = 10
            )
                ?.execute()
                ?.body()

            beers.postValue(randomBeer)

        }
    }

}