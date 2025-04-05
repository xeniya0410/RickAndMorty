package com.example.rickandmortyapp.model

data class LocationResponse(
    val results: List<Location>
)

data class Location(
    val name: String,
    val url: String,
    val type: String,
    val dimension: String
)