package com.example.punkapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.punkapi.ui.designsystem.organism.BeerDetailScreen
import com.example.punkapi.ui.designsystem.organism.HomeScreen

@Composable
fun AppNavGraph(
    onPromoClick: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                onPromoClick = onPromoClick,
                onBeerClick = { beerId ->
                    navController.navigate(Screen.BeerDetail.createRoute(beerId))
                }
            )
        }

        composable(
            route = Screen.BeerDetail.route,
            arguments = listOf(navArgument("beerId") { type = NavType.IntType })
        ) {
            BeerDetailScreen(onBack = { navController.popBackStack() })
        }
    }
}
