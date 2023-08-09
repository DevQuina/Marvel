package com.example.marvel.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel.R
import com.example.marvel.domain.model.CharacterModel

@Composable
fun ShowCharacterList(
    modifier: Modifier = Modifier,
    item: CharacterModel,

    ) {

    Row(
        modifier = modifier
            .padding(start = 6.dp, top = 12.dp, bottom = 12.dp)
    ) {


        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.wanda),
            error = painterResource(id = R.drawable.wanda),
            model = ImageRequest.Builder(LocalContext.current)
                .data("${item.thumbnail}/.${item.thumbnailExt}")
                .build(), contentDescription = ""
        )

        Spacer(Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = item.name,
                color = Color.Black
            )
        }
        Divider(modifier = Modifier.padding(top = 10.dp))
    }
}

