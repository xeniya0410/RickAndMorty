package com.example.rickandmortyapp.ui.theme.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.ui.theme.viewmodel.MainViewModel

@Composable
fun CharacterScreen(viewModel: MainViewModel) {
    val characters = viewModel.characters
    val isLoading = viewModel.isLoading
    val error = viewModel.error

    if (isLoading) {
        CircularProgressIndicator()
    } else if (error.isNotEmpty()) {
        Text("Ошибка: $error")
    } else {
        LazyColumn {
            items(characters) { character ->
                CharacterItem(character = character)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 8.dp)
            )
            Column {
                Text(text = character.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Статус: ${character.status}")
                Text(text = "Раса: ${character.species}")
            }
        }
    }
}
