package com.example.punkapi.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.punkapi.ui.designsystem.atoms.Chip
import com.example.punkapi.ui.theme.BeerBoxTheme

@Composable
fun FilterRow(
    modifier: Modifier = Modifier,
    onSearchText: (String) -> Unit = {}
) {
    val filters = listOf("Stout", "Lager", "Pilsner", "Ipa", "Porter", "Ale")

    var selected by remember { mutableStateOf<Int?>(null) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {

        itemsIndexed(filters) { idx, filter ->
            Chip(
                text = filter,
                selected = selected == idx
            ) {
                selected = if(selected == idx) null else idx
                onSearchText.invoke(if(selected == null) "" else filter)
            }
        }
    }
}

@Preview
@Composable
fun FilterRowPreview() {
    BeerBoxTheme {
        FilterRow()
    }
}