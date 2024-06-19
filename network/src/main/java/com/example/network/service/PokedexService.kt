package com.example.network.service

import com.example.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): Response<PokemonResponse>
}