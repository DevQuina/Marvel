package com.example.marvel.domain.model.repository



import com.example.marvel.data.dto.charactersDto.CharactersDTO


interface MarvelRepository {
    suspend fun getAllCharacters(offset:Int): CharactersDTO
    suspend fun getCharacterById(id: String): CharactersDTO

}