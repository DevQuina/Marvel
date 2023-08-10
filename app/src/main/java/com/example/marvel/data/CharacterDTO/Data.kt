package com.example.marvel.data.CharacterDTO

import com.example.marvel.data.dto.Result

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)