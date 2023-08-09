package com.example.marvel.data.dto

import com.example.marvel.data.dto.CharacterDTO.Result

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)