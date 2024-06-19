package com.example.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Immutable
@Serializable
@Parcelize
data class Pokemon(
    var page: Int = 0,
    val name: String,
    val url: String,
) : Parcelable {
    val pokemonName: String
        get() = name.replaceFirstChar { it.uppercase() }

    val pokemonUrl: String
        get() {
            val index = url.split("/".toRegex()).dropLast(1).last()
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                    "pokemon/other/official-artwork/$index.png"
        }
}