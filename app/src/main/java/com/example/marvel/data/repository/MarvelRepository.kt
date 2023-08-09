package com.example.marvel.domain.model.repository


import com.example.marvel.data.dto.CharactersDTO


interface MarvelRepository {
    suspend fun getAllCharacters(offset:Int): CharactersDTO
   /* suspend fun getCharacterById(id:String): CharacterDTO*/

}