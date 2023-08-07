package com.example.marvel.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CharacterlListScreen(

    dataList: List <CharacterModel>
){
    ShowCharacterList(character = CharacterModel(1,"Wanda ","something"))
    LazyColumn(modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        items(dataList){ character->
            ShowCharacterList(character = character)

        }
    }
}
@Preview
@Composable
fun CharacterListScreenPreview() {
}