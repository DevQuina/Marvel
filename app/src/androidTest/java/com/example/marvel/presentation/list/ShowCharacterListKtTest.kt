package com.example.marvel.presentation.list

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.marvel.CharacterTestDataBuilder
import org.junit.Rule
import org.junit.Test


class ShowCharacterListKtTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testShowCharacter() {
        rule.setContent {
            ShowCharacterList(
                CharacterTestDataBuilder()
                    .withName("Sample")
                    .buildSingle()
            ) {}
        }

        rule.onRoot().printToLog("MY TAG")

        rule.onNode(
            hasText("Sample") and
                    hasClickAction()
        ).assertHasClickAction()

    }
}