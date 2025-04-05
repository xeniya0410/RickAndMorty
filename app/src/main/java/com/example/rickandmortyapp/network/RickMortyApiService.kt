package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.CharacterResponse
import com.example.rickandmortyapp.model.LocationResponse
import com.example.rickandmortyapp.model.EpisodeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse
    @GET("location")
    suspend fun getLocations(@Query("page") page: Int = 1): LocationResponse
    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int = 1): EpisodeResponse

}
