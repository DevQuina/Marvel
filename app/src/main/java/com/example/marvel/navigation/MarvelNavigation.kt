package com.example.marvel.navigation



import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.marvel.presentation.detail.DetailScreen
import com.example.marvel.presentation.list.CharacterListScreen


fun NavGraphBuilder.addCharacterListScreen(navController: NavHostController) {
    composable(Screen.CharacterListScreen.route) {
        CharacterListScreen({ characterId ->
            navController.navigate("${Screen.CharacterDetailScreen.route}/$characterId")
        })
    }
}

fun NavGraphBuilder.addDetailScreen(

) {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterId}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) {navBackStackentry->
       val id = navBackStackentry.arguments?.getString("{characterId}") ?: ""
        DetailScreen( id = id)
    }
}


