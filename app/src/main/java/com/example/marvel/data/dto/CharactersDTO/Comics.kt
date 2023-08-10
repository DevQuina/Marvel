package com.example.marvel.data.dto

import com.example.marvel.data.CharacterDTO.Item

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)