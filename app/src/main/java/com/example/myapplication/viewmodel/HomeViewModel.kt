package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.EpisodateApi
import com.example.myapplication.data.TvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val shows: List<TvShow>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: EpisodateApi
) : ViewModel() {

    var uiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    var searchQuery by mutableStateOf("")
        private set

    init {
        loadPopularShows()
    }

    fun loadPopularShows() {
        viewModelScope.launch {
            uiState = HomeUiState.Loading
            try {
                val response = api.getMostPopular()
                uiState = HomeUiState.Success(response.tv_shows)
            } catch (e: Exception) {
                uiState = HomeUiState.Error("Erreur : ${e.message}")
            }
        }
    }

    fun onSearchChange(query: String) {
        searchQuery = query
        if (query.isEmpty()) {
            loadPopularShows()
        } else {
            viewModelScope.launch {
                uiState = HomeUiState.Loading
                try {
                    val response = api.searchShows(query)
                    uiState = HomeUiState.Success(response.tv_shows)
                } catch (e: Exception) {
                    uiState = HomeUiState.Error("Erreur recherche")
                }
            }
        }
    }
}