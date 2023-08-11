package com.example.marvel

import com.example.marvel.data.dto.Thumbnail
import com.example.marvel.domain.model.CharacterModel

class CharacterTestDataBuilder {
    val id = 0
    var name = ""
    var thumbnail = ""
    var description = ""
    var numElements: Int = 1

    fun withName(name: String): CharacterTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoUrl(thumbnail: Thumbnail): CharacterTestDataBuilder {
        this.thumbnail = thumbnail.path
        return this
    }

    fun withDescription(description: String): CharacterTestDataBuilder {
        this.description = description
        return this
    }

    fun withNumElements(numElements: Int): CharacterTestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun buildList(): List<CharacterModel> {
        val list = mutableListOf<CharacterModel>()

        for(i in 0 until numElements) {
            list.add(
                CharacterModel(
                    id,
                    name = name,
                    thumbnail =  thumbnail,
                    description = description,
                    thumbnailExt = thumbnail,

                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = CharacterModel(
        id = id,
        name = name,
        thumbnail =  thumbnail,
        description = description,
        thumbnailExt = thumbnail,
    )
}