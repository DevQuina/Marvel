package com.example.marvel.domain.use_cases


import com.example.marvel.data.dto.charactersDto.CharactersDTO
import com.example.marvel.domain.model.repository.MarvelRepository

class CharacterUseCase(
    private val repository: MarvelRepository
) {
    suspend operator fun invoke(id: String): CharactersDTO {
     return repository.getCharacterById( id )
    }
}