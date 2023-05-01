package com.example.punkapi.ui.designsystem.atoms

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadError(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "Error fetching data"
    )
}