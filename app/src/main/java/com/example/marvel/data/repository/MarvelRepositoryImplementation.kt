package com.example.marvel.data.repository

import com.example.marvel.data.CharacterDTO.MarvelApi

import com.example.marvel.data.dto.CharactersDTO


import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.utils.Constants
import com.example.marvel.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception


class MarvelRepositoryImplementation (
    private val api : MarvelApi
) :MarvelRepository{
    override suspend fun getAllCharacters(offset: Int): CharactersDTO {
        return api.getAllCharacters(offset=offset.toString())
    }

   /* override suspend fun getCharacterById(id: String): CharacterDTO {
        return api.getCharacterById(id)
    }*/


}