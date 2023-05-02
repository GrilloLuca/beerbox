package com.example.punkapi

import android.util.Log
import androidx.paging.flatMap
import androidx.paging.map
import androidx.paging.testing.asSnapshot
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.punkapi.api.PunkApi
import com.example.punkapi.api.repo.RemoteRepository
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.api.repo.Resource
import com.example.punkapi.api.usecase.GetBeerPageUseCase
import com.example.punkapi.models.Beer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.lang.Exception

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.punkapi", appContext.packageName)
    }

    companion object {
        val BEER_1 = Beer(1)
        val BEER_2 = Beer(2)
        val BEER_3 = Beer(3)
        const val ERROR_MESSAGE = "ERROR MESSAGE"
    }
    class SuccessMockedRepo: RepositoryContract {
        override suspend fun getBeers(
            page: Int,
            size: Int,
            beerName: String
        ): Resource<List<Beer>> {
            return Resource.Success(
                listOf(BEER_1, BEER_2, BEER_3)
            )
        }
    }
    class ErrorMockedRepo: RepositoryContract {
        override suspend fun getBeers(
            page: Int,
            size: Int,
            beerName: String
        ): Resource<List<Beer>> {
            return Resource.Error(ERROR_MESSAGE)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getBeerPageUseCaseTest() = runTest {

        val successUseCase = GetBeerPageUseCase(SuccessMockedRepo())

        val items: List<Beer> = successUseCase.execute("").asSnapshot(this) {

        }

        assertEquals(BEER_1, items[0])
        assertEquals(BEER_2, items[1])
        assertEquals(BEER_3, items[2])

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun errorPageUseCaseTest() = runTest {

        val errorUseCase = GetBeerPageUseCase(ErrorMockedRepo())

        try {
            errorUseCase.execute("").asSnapshot(this) {}
        } catch (e: Exception) {
            assertEquals(e.message, ERROR_MESSAGE)
        }


    }
}