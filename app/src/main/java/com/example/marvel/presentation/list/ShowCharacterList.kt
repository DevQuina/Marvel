package com.example.marvel.presentation.list


import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.marvel.R

@Composable
fun CharacterImage(image: String) {
    AsyncImage(
        modifier = Modifier
            .wrapContentSize()
            .size(120.dp)
            .clip(RoundedCornerShape(20.dp)),
        placeholder = painterResource(id = R.drawable.abomb),
        error = painterResource(id = R.drawable.abomb),
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .size(Size.ORIGINAL)
            .build(), contentDescription = ""
    , contentScale = ContentScale.Crop
    )

}