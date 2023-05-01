package com.example.punkapi.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.punkapi.models.Beer

@Composable
fun BeerList(
    modifier: Modifier = Modifier,
    beers: LazyPagingItems<Beer>,
    onClickBeer: (Beer) -> Unit = {}
) {

    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {

        items(beers) { beer ->
            beer?.let {
                BeerItem(
                    beer = beer,
                    onClickBeer = onClickBeer
                )
                Divider(color = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}
