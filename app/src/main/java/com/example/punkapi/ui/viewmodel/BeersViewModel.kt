package com.example.punkapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.api.repo.Resource
import com.example.punkapi.models.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    private val repo: RepositoryContract
) : ViewModel() {

    val beers: MutableLiveData<List<Beer>> = MutableLiveData()

    init {
        viewModelScope.launch {
            getBeers()
        }
    }

    private suspend fun getBeers() {

        repo.getBeers()
            .flowOn(Dispatchers.IO)
            .catch { e ->
                e.localizedMessage?.let { Log.d("BeersViewModel coroutine error", it) }
            }.collect {
                when (it) {
                    is Resource.Success -> {
                        beers.postValue(it.data)
                    }

                    is Resource.Error -> {
                        // TODO: ErrorHandler
                    }
                }
            }
    }

}