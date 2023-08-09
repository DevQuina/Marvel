package com.example.marvel.presentation.list

import com.example.marvel.domain.model.CharacterModel

data class HomeState (
    val isLoading : Boolean = false,
    val charactersList : List<CharacterModel> = emptyList(),
    val error : String = ""
        )