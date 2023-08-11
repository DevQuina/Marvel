package com.example.marvel.presentation.detail

import com.example.marvel.domain.model.CharacterModel


data class DetailState(
    val character: CharacterModel? = null,
    val isLoading: Boolean = false
)