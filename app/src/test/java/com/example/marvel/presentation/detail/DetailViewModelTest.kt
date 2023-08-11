package com.example.marvel.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvel.CharacterTestDataBuilder
import com.example.marvel.domain.model.CharacterModel
import com.example.marvel.domain.use_cases.CharacterUseCase
import com.example.marvel.testutil.DefaultDispacherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.getScopeId

class DetailViewModelTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispacherRule = DefaultDispacherRule()

    @MockK(relaxed = true)
    private lateinit var getCharacterUseCase: CharacterUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { getCharacterUseCase.invoke("0") }


        val viewModel = DetailViewModel(getCharacterUseCase)

        viewModel.getCharacter("test-id")

        val res = viewModel.character.getScopeId()

        Assert.assertThat(res, CoreMatchers.`is`("test-id"))
    }

}



