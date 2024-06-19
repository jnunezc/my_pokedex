package com.example.database.entity.mapper

import com.example.database.entity.PokemonEntity
import com.example.model.Pokemon

object PokemonEntityMapper : EntityMapper<List<Pokemon>, List<PokemonEntity>> {
  override fun asEntity(domain: List<Pokemon>): List<PokemonEntity> {
    return domain.map { pokemon ->
      PokemonEntity(
        page = pokemon.page,
        name = pokemon.name,
        url = pokemon.url,
      )
    }
  }

  override fun asDomain(entity: List<PokemonEntity>): List<Pokemon> {
    return entity.map { pokemonEntity ->
      Pokemon(
        page = pokemonEntity.page,
        name = pokemonEntity.name,
        url = pokemonEntity.url,
      )
    }
  }
}

fun List<Pokemon>.asEntity(): List<PokemonEntity> {
  return PokemonEntityMapper.asEntity(this)
}

fun List<PokemonEntity>?.asDomain(): List<Pokemon> {
  return PokemonEntityMapper.asDomain(this.orEmpty())
}