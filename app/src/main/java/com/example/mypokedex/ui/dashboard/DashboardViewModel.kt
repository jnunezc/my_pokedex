package com.example.mypokedex.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repository.DashboardRepository
import com.example.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import androidx.lifecycle.viewModelScope

@HiltViewModel
class DashboardViewModel @Inject constructor(
  private val dashboardRepository: DashboardRepository,
) : ViewModel() {

  internal val uiState: MutableStateFlow<DashboardUiState> =
    MutableStateFlow(DashboardUiState.Loading)

  private val pokemonFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
  val pokemonList: StateFlow<List<Pokemon>> = pokemonFetchingIndex.flatMapLatest { page ->
    dashboardRepository.getPokemons(
      page = page,
      onStart = { uiState.tryEmit(DashboardUiState.Loading) },
      onComplete = { uiState.tryEmit(DashboardUiState.Idle) },
      onError = { uiState.tryEmit(DashboardUiState.Error(it)) }
    )
  }.stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5_000),
    initialValue = emptyList(),
  )
}

internal sealed interface DashboardUiState {

  data object Idle : DashboardUiState

  data object Loading : DashboardUiState

  data class Error(val message: String?) : DashboardUiState

}