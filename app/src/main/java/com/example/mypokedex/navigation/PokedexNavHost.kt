package com.example.mypokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun PokedexNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = PokedexScreen.Dashboard) {
        pokedexNavigation(navController)
    }
}