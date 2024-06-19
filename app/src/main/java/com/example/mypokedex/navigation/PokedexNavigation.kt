package com.example.mypokedex.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.mypokedex.MainActivity
import com.example.mypokedex.ui.dashboard.Dashboard
import com.example.mypokedex.ui.dashboard.PokemonList
import com.example.mypokedex.ui.details.PokemonDetails

fun NavGraphBuilder.pokedexNavigation(navController: NavHostController) {
    composable<PokedexScreen.Dashboard> { Dashboard(navController = navController) }

    composable<PokedexScreen.Details>(
        typeMap = PokedexScreen.Details.typeMap
    ) {
        PokemonDetails(navController = navController)
    }
}