package com.example.mypokedex.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow

class DetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val pokemon = savedStateHandle.getStateFlow<Pokemon?>("pokemon", null)
    private val pokemonFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)

}