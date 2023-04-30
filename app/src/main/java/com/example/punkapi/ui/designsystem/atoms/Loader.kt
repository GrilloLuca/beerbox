package com.example.punkapi.ui.designsystem.atoms

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Loader(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}