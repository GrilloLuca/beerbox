package com.example.punkapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.punkapi.ui.designsystem.molecules.AppTopBar
import com.example.punkapi.ui.designsystem.organism.HomeScreen
import com.example.punkapi.ui.theme.BeerBoxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BeerBoxTheme {

                Scaffold(
                    topBar = {
                        AppTopBar(modifier = Modifier.padding(8.dp))
                    }
                ) { padding ->

                    Box(modifier = Modifier.padding(padding)) {

                        HomeScreen()

                    }
                }

            }
        }
    }
}