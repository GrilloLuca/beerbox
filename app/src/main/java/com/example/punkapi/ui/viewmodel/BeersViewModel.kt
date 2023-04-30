package com.example.punkapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.punkapi.api.datasource.PagingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    private val datasource: PagingDataSource
) : ViewModel() {

    val beers = Pager(
        config = PagingConfig(
            pageSize = 25
        ),
        pagingSourceFactory = {
            datasource
        }
    ).flow.cachedIn(viewModelScope)

}