package com.example.rickandmortyapp.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.repository.CharacterRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainViewModel : ViewModel() {
    private val repository = CharacterRepository()

    var characters by mutableStateOf<List<Character>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf("")
        private set

    var locations by mutableStateOf<List<Location>>(emptyList())
        private set

    var episodes by mutableStateOf<List<Episode>>(emptyList())
        private set

    init {
        fetchCharacters()
    }

    fun fetchCharacters(page: Int = 1) {
        viewModelScope.launch {
            isLoading = true
            error = ""
            try {
                val result = repository.getCharacters(page)
                characters = result
            } catch (e: Exception) {
                error = e.localizedMessage ?: "Ошибка при загрузке персонажей"
            }
            isLoading = false
        }
    }

    fun fetchLocations(page: Int = 1) {
        viewModelScope.launch {
            isLoading = true
            error = ""
            try {
                val result = repository.getLocations(page)
                locations = result
            } catch (e: Exception) {
                error = e.localizedMessage ?: "Ошибка при загрузке локаций"
            }
            isLoading = false
        }
    }

    fun fetchEpisodes(page: Int = 1) {
        viewModelScope.launch {
            isLoading = true
            error = ""
            try {
                val result = repository.getEpisodes(page)
                episodes = result
            } catch (e: Exception) {
                error = e.localizedMessage ?: "Ошибка при загрузке эпизодов"
            }
            isLoading = false
        }
    }
}
