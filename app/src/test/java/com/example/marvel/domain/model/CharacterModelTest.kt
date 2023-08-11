package com.example.marvel.domain.model

import com.example.marvel.CharacterTestDataBuilder
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class CharacterModelTest {

    var characterModel = CharacterModel(
        30,
        "Wanda",
        "descripcion",
        "https://foto",
        "jpg"
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        MatcherAssert.assertThat(characterModel, CoreMatchers.instanceOf(characterModel::class.java))
        MatcherAssert.assertThat(characterModel, CoreMatchers.notNullValue())
    }

    @Test
    fun `WHEN characterModel id is 30 EXPECT id = 30`() {
        val hero = CharacterTestDataBuilder()
            .buildSingle()
        MatcherAssert.assertThat(hero.id, CoreMatchers.`is`(0))
    }

    @Test
    fun `WHEN characterModel name is Wanda EXPECT name = Wanda`() {
        val hero = CharacterTestDataBuilder()
            .withName("Wanda")
            .buildSingle()
        MatcherAssert.assertThat(hero.name, CoreMatchers.`is`("Wanda"))
    }

    @Test
    fun `WHEN characterModel description is Wanda EXPECT description = descripcion`() {
        val hero = CharacterTestDataBuilder()
            .withName("descripcion")
            .buildSingle()
        MatcherAssert.assertThat(hero.name, CoreMatchers.`is`("descripcion"))
    }

    @Test
    fun `WHEN creates characterModel EXPECT thumbnail contains schema`() {

        MatcherAssert.assertThat(characterModel.thumbnail, characterModel.thumbnail.startsWith("https"))
    }
    @Test
    fun `WHEN creates characterModel EXPECT thumbnailExt contains schema`() {

        MatcherAssert.assertThat(characterModel.thumbnailExt, characterModel.thumbnailExt.startsWith("jpg"))
    }

}