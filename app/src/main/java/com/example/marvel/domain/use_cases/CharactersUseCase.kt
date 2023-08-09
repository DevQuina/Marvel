package com.example.marvel.domain.use_cases

import com.example.marvel.data.State
import com.example.marvel.domain.model.CharacterModel
import com.example.marvel.domain.model.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CharactersUseCase(
    private val repository : MarvelRepository
) {
    operator fun invoke(offset:Int): Flow<State<List<CharacterModel>>> = flow {
        try {
            emit(State.Loading<List<CharacterModel>>())
            val list = repository.getAllCharacters(offset=offset).data.results.map {
                it.toCharacter()
            }
            emit(State.Success<List<CharacterModel>>(list))
        }
        catch (e: HttpException){
            emit(State.Error<List<CharacterModel>>(e.printStackTrace().toString()))
        }
        catch (e: IOException){
            emit(State.Error<List<CharacterModel>>(e.printStackTrace().toString()))
        }
    }
}