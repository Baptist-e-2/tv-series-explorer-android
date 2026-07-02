package com.example.myapplication.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.data.TvShow
import com.example.myapplication.viewmodel.HomeUiState
import com.example.myapplication.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onShowClick: (Int) -> Unit
) {
    val state = viewModel.uiState

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.onSearchChange(it) },
            label = { Text("Rechercher une série") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (state) {
            is HomeUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is HomeUiState.Error -> {
                Text("Erreur: ${state.message}", color = MaterialTheme.colorScheme.error)
            }
            is HomeUiState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.shows) { show ->
                        TvShowItem(show, onClick = { onShowClick(show.id) })
                    }
                }
            }
        }
    }
}

@Composable
fun TvShowItem(show: TvShow, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            AsyncImage(
                model = show.image_thumbnail_path,
                contentDescription = show.name,
                modifier = Modifier.height(200.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = show.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp),
                maxLines = 1
            )
        }
    }
}