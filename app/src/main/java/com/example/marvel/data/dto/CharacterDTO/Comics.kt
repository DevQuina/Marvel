package com.example.marvel.data.dto.CharacterDTO

import com.example.marvel.data.dto.Item

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)