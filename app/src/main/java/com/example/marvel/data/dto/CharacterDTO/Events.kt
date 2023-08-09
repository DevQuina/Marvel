package com.example.marvel.data.dto.CharacterDTO

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<com.example.marvel.data.dto.CharacterDTO.Item>,
    val returned: Int
)