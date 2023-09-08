package com.example.marvel.presentation.list


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvel.domain.model.CharacterModel


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    characters: List<CharacterModel> = emptyList(),
    onItemClick: (Int) -> Unit,
) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        LazyVerticalGrid(

            contentPadding = PaddingValues(vertical = 6.dp),
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Adaptive(minSize = 128.dp),
            content = {
                items(characters.size) { index ->
                    ShowCharacterList(

                        item = characters[index]
                    ) { onItemClick(it) }
                }
            }
        )
        if (isLoading) FullScreenLoading()
    }
}




