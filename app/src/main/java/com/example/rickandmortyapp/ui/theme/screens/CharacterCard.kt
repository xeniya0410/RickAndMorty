package com.example.rickandmortyapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.model.Character

@Composable
fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {

            AsyncImage(
                model = character.image.replace("http", "https"),
                contentDescription = character.name,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(character.name, style = MaterialTheme.typography.h6)
                Text("Status: ${character.status}")
                Text("Species: ${character.species}")
            }
        }
    }
}

