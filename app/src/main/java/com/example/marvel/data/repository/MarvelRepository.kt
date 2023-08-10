package com.example.marvel.domain.model.repository


import com.example.marvel.data.CharacterDTO.CharacterDTO
import com.example.marvel.data.dto.CharactersDTO
import com.example.marvel.domain.model.CharacterModel


interface MarvelRepository {
    suspend fun getAllCharacters(offset:Int): CharactersDTO
    suspend fun getCharacterById(id: String): CharacterModel

}