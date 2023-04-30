package com.example.punkapi.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.punkapi.models.Beer
import com.example.punkapi.ui.BeerItemPreview
import com.example.punkapi.ui.theme.BeerBoxTheme

@Composable
fun BeerItem(beer: Beer) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        val model = ImageRequest.Builder(LocalContext.current)
            .data(beer.image_url)
            .crossfade(true)
            .diskCacheKey("$beer.id")
            .networkCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(horizontal =  20.dp),
            model = model.build(),
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