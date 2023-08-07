package com.example.marvel.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.R

@Composable
fun ShowCharacterList(
    character: CharacterModel

) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = (CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )),
        shape = RoundedCornerShape(10.dp)

    ) {
        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            //TODO dentro de clickable { onClick.invoke }
            .clickable { },
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.wanda), contentDescription ="" )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Wanda",
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }

}

@Composable
@Preview
fun ShowCharacterPreview() {
    ShowCharacterList(character = CharacterModel(1,"Wanda","R.drawable.wanda"))
}