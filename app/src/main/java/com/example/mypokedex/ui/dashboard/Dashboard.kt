package com.example.mypokedex.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.mypokedex.ui.components.PokedexLoading
import kotlinx.collections.immutable.toImmutableList

@Composable
fun Dashboard(
  dashboardViewModel: DashboardViewModel = hiltViewModel(),
  navController: NavHostController
) {
  val pokemonList by dashboardViewModel.pokemonList.collectAsStateWithLifecycle()
  val uiState by dashboardViewModel.uiState.collectAsStateWithLifecycle()

  Column(modifier = Modifier.fillMaxSize()) {
    PokedexAppBar()
    Box(modifier = Modifier.fillMaxSize()) {

      PokemonList(pokemonList = pokemonList.toImmutableList(), navController = navController)
      if (uiState == DashboardUiState.Loading) {
        PokedexLoading()
      }
    }
  }
}