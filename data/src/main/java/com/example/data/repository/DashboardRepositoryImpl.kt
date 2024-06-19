package com.example.data.repository

import com.example.database.dao.PokemonDao
import com.example.database.entity.mapper.asDomain
import com.example.database.entity.mapper.asEntity
import com.example.model.Pokemon
import com.example.network.service.PokedexClient
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
  private val pokedexClient: PokedexClient,
  private val pokemonDao: PokemonDao,
) : DashboardRepository {
  override fun getPokemons(
    page: Int, onStart: () -> Unit,
    onComplete: () -> Unit,
    onError: (String?) -> Unit,
  ) = flow {
    var pokemons = pokemonDao.getPokemonList(page).asDomain()
    if (pokemons.isEmpty()) {
      try {
        val response = pokedexClient.getPokemons(page = page)
        pokemons = response.body()?.results ?: listOf()
        pokemons.forEach { pokemon -> pokemon.page = page }
        pokemonDao.insertPokemonList(pokemons.asEntity())
        emit(pokemonDao.getAllPokemonList(page).asDomain())
      } catch (error: Throwable) {
        onError(error.toString())
      }
    } else {
      emit(pokemonDao.getAllPokemonList(page).asDomain())
    }
  }.onStart { onStart() }.onCompletion { onComplete() }
}