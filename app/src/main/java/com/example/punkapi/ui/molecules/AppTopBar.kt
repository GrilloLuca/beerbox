package com.example.punkapi.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.punkapi.ui.atoms.HeaderBox

@Composable
fun AppTopBar(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderBox(modifier = Modifier.align(Alignment.CenterHorizontally))
    }

}

@Preview(showBackground = true)
@Composable
private fun AppTopBarPreview() {
    AppTopBar()
}