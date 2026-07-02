package com.example.myapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.viewmodel.DetailUiState
import com.example.myapplication.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    showId: Int,
    onBackClick: () -> Unit, // <--- C'EST CETTE LIGNE QUI TE MANQUAIT !
    viewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(showId) {
        viewModel.loadShowDetails(showId)
    }

    val state = viewModel.uiState

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is DetailUiState.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            is DetailUiState.Error -> Text(text = state.message, color = Color.Red, modifier = Modifier.align(Alignment.Center))
            is DetailUiState.Success -> {
                val show = state.detail
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Image
                    AsyncImage(
                        model = show.image_path,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(300.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = show.name, style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "⭐ Rating: ${show.rating.substring(0,3)}/10", style = MaterialTheme.typography.titleMedium)
                        Text(text = "📺 Épisodes: ${show.episodes.size}", style = MaterialTheme.typography.titleMedium)
                        Text(text = "🎭 Genres: ${show.genres.joinToString(", ")}")

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Résumé", style = MaterialTheme.typography.titleLarge)
                        Text(text = show.description)
                    }
                }

                // Le bouton retour visuel
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                        .background(color = Color.Black.copy(alpha = 0.5f), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retour",
                        tint = Color.White
                    )
                }
            }
        }
    }
}