package com.example.punkapi.ui.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.punkapi.ui.theme.BeerBoxTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {

    var text by remember { mutableStateOf(TextFieldValue("")) }

    Card(
        modifier = modifier
    ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            ),
            onValueChange = { newText ->
                text = newText
            })

    }

}

@Preview
@Composable
fun SearchBarPreview() {
    BeerBoxTheme() {
        SearchBar()
    }
}