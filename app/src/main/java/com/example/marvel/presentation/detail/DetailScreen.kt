package com.example.marvel.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel.R
import com.example.marvel.domain.model.CharacterModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun DetailScreen(
    id: String,
    detailViewModel: DetailViewModel = koinViewModel(),
) {

    detailViewModel.getCharacter(id)
    val state = detailViewModel.state


    DetailContent(
        item = state.character
    )

}


@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    item: CharacterModel?
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {


        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 6.dp, top = 12.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.wanda),
                error = painterResource(id = R.drawable.wanda),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${item?.thumbnail}/.${item?.thumbnailExt}")
                    .build(), contentDescription = ""
            )

            Spacer(Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = item?.name ?: "Wanda",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            ) {
                Text(text = "Description",
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = item?.description
                        ?: "Wanda Maximoff, the Scarlet Witch, is a Romani sorceress and twin sister of the speedster Quicksilver. Once believed to have been mutant children of Magneto, the twins are in truth orphans enhanced by the High Evolutionary at Mount Wundagore in Transia. The Scarlet Witch became a conduit of chaos magic, allowing her to shift probabilities and warp reality itself by casting various \"hexes\".[6][23] After being saved from an angry mob by Magneto, the Scarlet Witch and her brother joined the Brotherhood of Evil Mutants to fight for Magneto's mutant supremacy cause.[4] Disagreeing with Magneto's ruthless approach to human hostilities towards mutants, the twins left him and joined the super-heroic Avengers instead",
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}
