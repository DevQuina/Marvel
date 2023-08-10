package com.example.marvel.di

import com.example.marvel.domain.use_cases.CharacterUseCase
import com.example.marvel.domain.use_cases.CharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    single { CharactersUseCase(get()) }
    single { CharacterUseCase(get()) }
}