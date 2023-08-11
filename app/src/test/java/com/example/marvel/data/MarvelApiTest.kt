package com.example.marvel.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.unit.Constraints
import com.example.marvel.data.characterDto.MarvelApi
import com.example.marvel.data.dto.charactersDto.CharactersDTO
import com.example.marvel.di.baseUrl
import com.example.marvel.testutil.DefaultDispacherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.mockk.InternalPlatformDsl.toArray
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class MarvelApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispacherRule()


    private lateinit var api: MarvelApi

    @Before
    fun setup() {
        api = retrofit.create(MarvelApi::class.java)
    }

    @Test
    fun `WHEN request character list EXPECT result`(offset: Int) = runTest {
        val result = api.getAllCharacters(offset=offset.toString())

       assertThat(result.toArray().isNotEmpty(), CoreMatchers.`is`(true))
    }

    @Test
    fun `WHEN request whit search EXPECT item`(offset: Int) = runTest {
        val result = api.getAllCharacters(offset=offset.toString())

        assertThat(result.toArray().size, CoreMatchers.`is`(1))
    }



    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}