package com.example.marvel.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object CharacterListScreen: Screen(
        route= "characterList",
        arguments = emptyList()
    )
    object CharacterDetailScreen: Screen(
        route = "characterDetail",
        arguments = listOf(
            navArgument("characterId"){
                type = NavType.StringType
                nullable = false
            }
        )
    )
}