package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.EpisodateApi
import com.example.myapplication.data.TvShowDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Les états possibles de l'écran détail
sealed interface DetailUiState {
    object Loading : DetailUiState
    data class Success(val detail: TvShowDetail) : DetailUiState
    data class Error(val message: String) : DetailUiState
}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val api: EpisodateApi
) : ViewModel() {

    var uiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    fun loadShowDetails(id: Int) {
        viewModelScope.launch {
            uiState = DetailUiState.Loading
            try {
                // On appelle l'API pour avoir les détails précis
                val response = api.getShowDetails(id)
                uiState = DetailUiState.Success(response.tvShow)
            } catch (e: Exception) {
                uiState = DetailUiState.Error("Erreur : ${e.message}")
            }
        }
    }
}