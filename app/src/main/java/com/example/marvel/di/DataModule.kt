package com.example.marvel.di

import com.example.marvel.data.CharacterDTO.MarvelApi
import com.example.marvel.data.repository.MarvelRepositoryImplementation
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val baseUrl = Constants.BASE_URL
val dataModule = module {
    single<Retrofit> {
        Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    }

    single <MarvelRepository>{ MarvelRepositoryImplementation (get()) }
    single<MarvelApi> {
        getMarvelApi(get())
    }
}

private fun getMarvelApi(retrofit: Retrofit) =
    retrofit.create(MarvelApi::class.java)