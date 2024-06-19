package com.example.mypokedex.navigation

import com.example.model.Pokemon
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

sealed interface PokedexScreen {
    @Serializable
    data object Dashboard : PokedexScreen

    @Serializable
    data class Details(val pokemon: Pokemon) : PokedexScreen {
        companion object {
            val typeMap = mapOf(typeOf<Pokemon>() to PokemonType)
        }
    }
}