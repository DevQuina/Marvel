package com.example.marvel.domain.model

import com.example.marvel.data.dto.Thumbnail

data class CharacterModel(
    val id : Int,
    val name : String,
    val description : String,
    val thumbnail : String,
    val thumbnailExt: String,
    val comics : List<String>,
)