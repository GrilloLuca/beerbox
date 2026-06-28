package com.example.punkapi.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object BeerDetail : Screen("beer/{beerId}") {
        fun createRoute(beerId: Int) = "beer/$beerId"
    }
}
