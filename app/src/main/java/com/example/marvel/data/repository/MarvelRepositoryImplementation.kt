package com.example.marvel.data.repository

import com.example.marvel.data.characterDto.MarvelApi

import com.example.marvel.data.dto.charactersDto.CharactersDTO


import com.example.marvel.domain.model.repository.MarvelRepository


class MarvelRepositoryImplementation (
    private val api : MarvelApi
) :MarvelRepository{
    override suspend fun getAllCharacters(offset: Int): CharactersDTO {
        return api.getAllCharacters(offset=offset.toString())
    }

   override suspend fun getCharacterById(id: String): CharactersDTO {
        return  api.getCharacterById(id)
   }


}