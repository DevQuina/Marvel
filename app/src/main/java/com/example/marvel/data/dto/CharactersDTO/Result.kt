package com.example.marvel.data.dto

import com.example.marvel.data.CharacterDTO.Comics
import com.example.marvel.data.CharacterDTO.Events
import com.example.marvel.data.CharacterDTO.Series
import com.example.marvel.data.CharacterDTO.Stories
import com.example.marvel.data.CharacterDTO.Thumbnail
import com.example.marvel.data.CharacterDTO.Url
import com.example.marvel.domain.model.CharacterModel

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
){
    fun toListCharacter(): CharacterModel {
        return CharacterModel(
            id=id,
            name=name,
            description=description,
            thumbnail = thumbnail.path,
            thumbnailExt=thumbnail.extension,
            comics = comics.items.map {
                it.name
            }
        )
    }
}