package com.example.punkapi.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.punkapi.models.Beer
import com.example.punkapi.ui.BeerItemPreview
import com.example.punkapi.ui.molecules.BeerList
import com.example.punkapi.ui.molecules.PromoBanner
import com.example.punkapi.ui.molecules.SearchBar
import com.example.punkapi.ui.theme.BeerBoxTheme
import com.example.punkapi.viewmodels.BeersViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: BeersViewModel = viewModel(),
) {
    val beers: List<Beer>? = viewModel.beers.observeAsState().value

    HomeScreenUI(
        modifier = modifier,
        beers = beers
    )
}
@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    beers: List<Beer>? = null,
) {

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SearchBar()
        PromoBanner()

        beers?.let {
            BeerList(beers = it)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(
    @PreviewParameter(BeerItemPreview::class) beers: List<Beer>
) {
    BeerBoxTheme {
        HomeScreenUI(
            beers = beers
        )
    }
}