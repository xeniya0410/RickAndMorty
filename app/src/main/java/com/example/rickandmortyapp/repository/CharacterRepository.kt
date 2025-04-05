package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.network.RetrofitInstance

class CharacterRepository {
    suspend fun getCharacters(page: Int = 1): List<Character> {
        return RetrofitInstance.api.getCharacters(page).results
    }
    suspend fun getLocations(page: Int = 1): List<Location> {
        return RetrofitInstance.api.getLocations(page).results
    }

    suspend fun getEpisodes(page: Int = 1): List<Episode> {
        return RetrofitInstance.api.getEpisodes(page).results
    }

}
