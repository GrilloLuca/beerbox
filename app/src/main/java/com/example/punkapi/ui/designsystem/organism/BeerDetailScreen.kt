package com.example.punkapi.ui.designsystem.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.punkapi.api.repo.Resource
import com.example.punkapi.ui.designsystem.atoms.LoadError
import com.example.punkapi.ui.designsystem.atoms.Loader
import com.example.punkapi.ui.viewmodel.BeerDetailViewModel

@Composable
fun BeerDetailScreen(
    onBack: () -> Unit,
    viewModel: BeerDetailViewModel = hiltViewModel()
) {
    val state by viewModel.beerState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(onClick = onBack) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Box(modifier = Modifier.fillMaxSize()) {
            when (val s = state) {
                null -> Loader()
                is Resource.Error -> LoadError()
                is Resource.Success -> {
                    val beer = s.data ?: return@Box
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        AsyncImage(
                            model = "${com.example.punkapi.BuildConfig.PUNK_API_BASE_URL}images/${beer.image}",
                            contentDescription = beer.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                        beer.name?.let {
                            Text(text = it, style = MaterialTheme.typography.headlineMedium)
                        }
                        beer.tagline?.let {
                            Text(text = it, style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary)
                        }
                        beer.description?.let {
                            Text(text = it, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }
}
