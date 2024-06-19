package com.example.mypokedex.ui.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.model.Pokemon
import com.example.mypokedex.R
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PokemonDetails(
  navController: NavHostController,
  detailsViewModel: DetailsViewModel = hiltViewModel(),
) {
  val pokemon = detailsViewModel.pokemon.collectAsStateWithLifecycle()
  DetailsHeader(navController, pokemon = pokemon.value)
}

@Composable
private fun DetailsHeader(
  navController: NavHostController,
  pokemon: Pokemon?
) {
  val shape = RoundedCornerShape(
    topStart = 0.dp,
    topEnd = 0.dp,
    bottomStart = 64.dp,
    bottomEnd = 64.dp,
  )

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(280.dp)
      .shadow(elevation = 8.dp, shape = shape)
      .background(Color.LightGray)
  ) {
    Row(
      modifier = Modifier
        .padding(12.dp)
        .statusBarsPadding(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Icon(
        modifier = Modifier
          .padding(end = 6.dp)
          .clickable { navController.navigateUp() },
        painter = painterResource(id = R.drawable.ic_arrow_back),
        tint = Color.White,
        contentDescription = null,
      )

      Text(
        modifier = Modifier.padding(horizontal = 10.dp),
        text = pokemon?.pokemonName.orEmpty(),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
      )
    }
    Text(
      modifier = Modifier
        .align(Alignment.TopEnd)
        .padding(12.dp)
        .statusBarsPadding(),
      text = "#017",
      fontSize = 18.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )

    GlideImage(
      imageModel = { pokemon?.pokemonUrl },
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .size(180.dp),
      imageOptions = ImageOptions(contentScale = ContentScale.Inside)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsPreview() {

}