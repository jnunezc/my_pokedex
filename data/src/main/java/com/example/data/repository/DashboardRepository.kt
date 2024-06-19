package com.example.data.repository

import com.example.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {

  fun getPokemons(
    page: Int, onStart: () -> Unit,
    onComplete: () -> Unit,
    onError: (String?) -> Unit,
  ): Flow<List<Pokemon>>
}