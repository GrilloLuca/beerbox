package com.example.punkapi.ui.designsystem.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.punkapi.ui.designsystem.atoms.LoadError
import com.example.punkapi.ui.designsystem.atoms.Loader
import com.example.punkapi.ui.designsystem.molecules.BeerList
import com.example.punkapi.ui.designsystem.molecules.FilterRow
import com.example.punkapi.ui.designsystem.molecules.PromoBanner
import com.example.punkapi.ui.designsystem.molecules.SearchBar
import com.example.punkapi.ui.viewmodel.BeersViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: BeersViewModel = hiltViewModel(),
    onPromoClick: () -> Unit = {},
    onBeerClick: (Int) -> Unit = {}
) {
    /**
     * As MVVM architecture, the UI component observes the view model flow, by collecting as pagingItems
     * The BeerList Component has been recomposed each time the beerFlow emits a new value
     * the SearchBar and the FilterRow components calls a viewModel function for filtering the list
     */
    val beers = viewModel.beerFlow.collectAsLazyPagingItems()

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        SearchBar(onSearchText = viewModel::searchBeer)

        PromoBanner {
            onPromoClick()
        }

        FilterRow(onSearchText = viewModel::filterBeers)

        Box(modifier = Modifier.fillMaxSize()) {
            when (beers.loadState.refresh) {
                is LoadState.Loading -> Loader()
                is LoadState.Error -> LoadError()
                else -> BeerList(
                    beers = beers,
                    onClickBeer = {
                        onBeerClick(it.id)
                    })
            }
        }
    }

}
