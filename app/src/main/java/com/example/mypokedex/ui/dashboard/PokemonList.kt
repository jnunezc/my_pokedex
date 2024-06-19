package com.example.mypokedex.ui.dashboard

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.model.Pokemon
import com.example.mypokedex.navigation.PokedexScreen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PokemonList(
  pokemonList: ImmutableList<Pokemon>,
  navController: NavHostController
) {
  LazyVerticalGrid(columns = GridCells.Fixed(2)) {
    items(pokemonList) { pokemon ->
      Card(
        modifier = Modifier
          .size(200.dp)
          .padding(5.dp),
        onClick = { navController.navigate(PokedexScreen.Details(pokemon = pokemon)) }) {
        Text(text = pokemon.pokemonName, modifier = Modifier.align(Alignment.CenterHorizontally))
        GlideImage(
          imageModel = { pokemon.pokemonUrl },
          imageOptions = ImageOptions(contentScale = ContentScale.Inside),
          modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
        )
      }
    }
  }
}
