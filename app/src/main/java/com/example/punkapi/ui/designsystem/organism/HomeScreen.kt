package com.example.punkapi.ui.designsystem.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.punkapi.models.Beer
import com.example.punkapi.ui.BeerItemPreview
import com.example.punkapi.ui.designsystem.atoms.Loader
import com.example.punkapi.ui.designsystem.molecules.BeerList
import com.example.punkapi.ui.designsystem.molecules.PromoBanner
import com.example.punkapi.ui.designsystem.molecules.SearchBar
import com.example.punkapi.ui.theme.BeerBoxTheme
import com.example.punkapi.ui.viewmodel.BeersViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: BeersViewModel = viewModel(),
) {
    val beers = viewModel.beers.collectAsLazyPagingItems()

    HomeScreenUI(
        modifier = modifier,
        beers = beers
    )
}

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    beers: LazyPagingItems<Beer>? = null,
) {

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SearchBar()
        PromoBanner()

        Box(modifier = Modifier.fillMaxSize()) {
            beers?.let {
                when (it.loadState.refresh) {
                    is LoadState.Loading -> Loader(
                        modifier = Modifier.align(Alignment.Center)
                    )
                    else -> BeerList(beers = it)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(
    @PreviewParameter(BeerItemPreview::class) beers: List<Beer>
) {
    BeerBoxTheme {
//        HomeScreenUI(
//            beers = LazyPagingItems(beers)
//        )
    }
}