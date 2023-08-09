package com.example.marvel.data.dto

import com.example.marvel.data.dto.CharacterDTO.Item

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)