package com.example.marvel.di

import coil.ImageLoader
import com.example.marvel.data.CharacterDTO.MarvelApi
import com.example.marvel.data.repository.MarvelRepositoryImplementation
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.utils.Constants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val baseUrl = Constants.BASE_URL
val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

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