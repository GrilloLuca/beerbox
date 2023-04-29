package com.example.punkapi.ui.designsystem.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.punkapi.models.Beer
import com.example.punkapi.ui.BeerItemPreview
import com.example.punkapi.ui.theme.BeerBoxTheme

@Composable
fun BeerItem(beer: Beer) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(horizontal =  20.dp),
            model = beer.image_url,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = beer.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = beer.tagline,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = beer.description,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = "MORE INFO",
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun BeerItemPreview(
    @PreviewParameter(BeerItemPreview::class) beers: List<Beer>
) {
    BeerBoxTheme() {
        BeerItem(beers[0])
    }
}