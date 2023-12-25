/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.data

import androidx.paging.PagingSource
import androidx.paging.testing.asSnapshot
import dev.kadirkid.pagingtest.character.data.CharacterApi
import dev.kadirkid.pagingtest.character.data.CharacterPagingSource
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactory
import dev.kadirkid.pagingtest.character.model.Character
import dev.kadirkid.pagingtest.character.model.Location
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlin.RuntimeException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

//@RunWith(RobolectricTestRunner::class)
//@Config(manifest=Config.NONE)
class MainViewModelTest {
    private val api: CharacterApi = mockk(relaxed = true)
    private val source: CharacterPagingSource = mockk(relaxUnitFun = true) {
        every { keyReuseSupported } returns false
    }
    private val sourceFactory: CharacterPagingSourceFactory = mockk {
        every { create() } returns source
    }

    private val viewModel = MainViewModel(sourceFactory)

    @Test
    fun successfulWithSingleLoadIfNoNextKey() {
        runTest {
            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
                data = listOf(character),
                prevKey = null,
                nextKey = null
            )

            val result = viewModel.uiState.asSnapshot()

            assertEquals(listOf(character), result)
        }
    }

    @Test
    fun successfulWithMultipleLoadsIfDataIsInsufficient() {
        runTest {
            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
                data = generateSequence { character }.take(3).toList(),
                prevKey = null,
                nextKey = "2"
            ) andThen PagingSource.LoadResult.Page(
                data = generateSequence { character }.take(4).toList(),
                prevKey = "2",
                nextKey = "3"
            ) andThen PagingSource.LoadResult.Page(
                data = generateSequence { character }.take(3).toList(),
                prevKey = "3",
                nextKey = "4"
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character),
                prevKey = "4",
                nextKey = "5"
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character),
                prevKey = "5",
                nextKey = "6"
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character),
                prevKey = "6",
                nextKey = "7"
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character),
                prevKey = "7",
                nextKey = "8"
            )

            val result = viewModel.uiState.asSnapshot()
            val expected = generateSequence { character }.take(12).toList()
            assertEquals(expected, result)

            coVerify(exactly = 5) { source.load(any()) }
        }
    }

    @Test
    fun successfulWithMultipleLoadsUntilNextKeyIsNull() {
        runTest {
            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
                data = generateSequence { character }.take(3).toList(),
                prevKey = null,
                nextKey = "2"
            ) andThen PagingSource.LoadResult.Page(
                data = generateSequence { character }.take(4).toList(),
                prevKey = "2",
                nextKey = "3"
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character, character),
                prevKey = "3",
                nextKey = null
            ) andThen PagingSource.LoadResult.Page(
                data = listOf(character), // NOT CALLED
                prevKey = "4",
                nextKey = "5"
            )

            val result = viewModel.uiState.asSnapshot()
            val expected = generateSequence { character }.take(9).toList()
            assertEquals(expected, result)

            coVerify(exactly = 3) { source.load(any()) }
        }
    }

    @Test
    fun failure() {
        runTest {
            coEvery { source.load(any()) } returns PagingSource.LoadResult.Error(RuntimeException("Tough luck"))
            try {
                viewModel.uiState.asSnapshot()
                fail("Should fail with RuntimeException")
            } catch (e: RuntimeException) {
                assertEquals("Tough luck", e.message)
            }
        }
    }

    private companion object {
        val character = Character(
            id = 1,
            name = "Dummy Character",
            status = Character.Status.ALIVE,
            species = "Human",
            type = "Dummy Type",
            gender = "Male",
            origin = Location("Dummy Origin", "https://dummyorigin.com"),
            location = Location("Dummy Location", "https://dummylocation.com"),
            image = "https://dummyimage.com",
            episode = listOf("https://dummyepisode.com/1", "https://dummyepisode.com/2"),
            url = "https://dummycharacter.com",
            created = "2021-01-01"
        )
    }
}
