package com.example.mypokedex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BoxScope.PokedexLoading() {
  CircularProgressIndicator(
    modifier = Modifier.align(Alignment.Center),
    color = Color.Green
  )
}

@Preview
@Composable
private fun PokedexLoadingPreview(){
  Box(modifier = Modifier.fillMaxSize()) {
    PokedexLoading()
  }
}