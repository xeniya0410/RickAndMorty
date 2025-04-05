package com.example.rickandmortyapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.model.Episode

@Composable
fun EpisodeCard(episode: Episode) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(episode.name, style = MaterialTheme.typography.h6)
                Text("Код: ${episode.episode}")
                Text("Дата: ${episode.air_date}")
            }
        }
    }
}

