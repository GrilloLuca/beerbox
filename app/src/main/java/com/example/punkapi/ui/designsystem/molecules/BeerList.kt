package com.example.punkapi.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.punkapi.models.Beer
import com.example.punkapi.ui.BeerItemPreview
import com.example.punkapi.ui.theme.BeerBoxTheme

@Composable
fun BeerList(
    modifier: Modifier = Modifier,
    beers: LazyPagingItems<Beer>,
) {

    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {

        items(beers) { beer ->
            beer?.let {
                BeerItem(beer = beer)
                Divider(color = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}

@Preview
@Composable
fun BeerListPreview(
    @PreviewParameter(BeerItemPreview::class) beers: List<Beer>
) {
    BeerBoxTheme() {
//        BeerList(beers = beers)
    }
}