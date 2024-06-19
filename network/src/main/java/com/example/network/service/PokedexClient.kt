package com.example.network.service

import com.example.model.PokemonResponse
import retrofit2.Response
import javax.inject.Inject

class PokedexClient @Inject constructor(private val pokedexService: PokedexService) {
    suspend fun getPokemons(page: Int): Response<PokemonResponse> =
        pokedexService.getPokemons(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE,
        )

    companion object {
        private const val PAGING_SIZE = 20
    }
}