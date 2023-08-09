package com.example.marvel.data.dto.CharacterDTO

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)