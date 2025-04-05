package com.example.rickandmortyapp.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortyapp.ui.theme.viewmodel.MainViewModel

@Composable
fun LocationScreen(viewModel: MainViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchLocations()
    }

    val locations = viewModel.locations
    val isLoading = viewModel.isLoading
    val error = viewModel.error

    when {
        isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        error.isNotEmpty() -> {
            Text(text = error)
        }

        else -> {
            LazyColumn {
                items(locations) { location ->
                    LocationCard(location = location)
                }
            }
        }
    }
}
