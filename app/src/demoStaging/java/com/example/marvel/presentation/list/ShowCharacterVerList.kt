package com.example.marvel.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.marvel.R
import com.example.marvel.components.StarComponent
import com.example.marvel.domain.model.CharacterModel

@Composable
fun ShowCharacterList(
    item: CharacterModel,
    onItemClick: (Int) -> Unit,


    ) {
    var starred by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .clickable { onItemClick(item.id) }
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)


    ) {


        CharacterImage(item.thumbnail + "." + item.thumbnailExt)
        Spacer(Modifier.width(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = item.name,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(10.dp))

            AndroidView(
                modifier = Modifier.clickable {
                    val newState = !starred
                    starred = newState
                },
                factory = { context ->
                    StarComponent(context).apply {
                        this.checked = starred
                    }
                },
                update = {
                    it.checked = starred
                }
            )
        }

    }
}







