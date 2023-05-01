package com.example.punkapi.ui.designsystem.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.punkapi.ui.theme.BeerBoxTheme

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean = false,
    onClick: (String) -> Unit = {}
) {

    Button(
        modifier = modifier.height(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
            contentColor = if(selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
        ),
        onClick = {
            onClick.invoke(text)
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }

}

@Preview
@Composable
private fun ChipPreview() {
    BeerBoxTheme {
        Chip(text = "Blonde")
    }
}

@Preview
@Composable
private fun ChipPreviewSelected() {
    BeerBoxTheme {
        Chip(text = "Blonde", selected = true)
    }
}