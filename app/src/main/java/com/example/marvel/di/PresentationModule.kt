package com.example.marvel.di

import com.example.marvel.presentation.list.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
   viewModel{ CharacterListViewModel(get()) }
}