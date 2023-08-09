package com.example.marvel.data.dto

import com.example.marvel.data.dto.CharacterDTO.ItemXXX

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)