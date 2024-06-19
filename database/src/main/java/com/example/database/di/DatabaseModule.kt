package com.example.database.di

import android.app.Application
import androidx.room.Room
import com.example.database.PokedexDatabase
import com.example.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

  @Provides
  @Singleton
  fun providesAppDatabase(
    application: Application,
  ): PokedexDatabase {
    return Room
      .databaseBuilder(application, PokedexDatabase::class.java, "Pokedex.db")
      .build()
  }

  @Provides
  @Singleton
  fun providePokemonDao(appDatabase: PokedexDatabase): PokemonDao {
    return appDatabase.pokemonDao()
  }
}