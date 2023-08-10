package com.example.marvel.data.repository

import com.example.marvel.data.CharacterDTO.CharacterDTO
import com.example.marvel.data.CharacterDTO.MarvelApi

import com.example.marvel.data.dto.CharactersDTO
import com.example.marvel.domain.model.CharacterModel


import com.example.marvel.domain.model.repository.MarvelRepository


class MarvelRepositoryImplementation (
    private val api : MarvelApi
) :MarvelRepository{
    override suspend fun getAllCharacters(offset: Int): CharactersDTO {
        return api.getAllCharacters(offset=offset.toString())
    }

   override suspend fun getCharacterById(id: String): CharacterModel {
        return  api.getCharacterById(id)
   }


}