package dev.kadirkid.pagingtest.character.data

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.kadirkid.pagingtest.character.model.Character
import dev.kadirkid.pagingtest.character.model.CharacterResponse
import dev.kadirkid.pagingtest.character.model.Info
import dev.kadirkid.pagingtest.character.model.Location
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.RuntimeException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class CharacterPagingSourceTest {
    private val api: CharacterApi = mockk()

    private val source = CharacterPagingSource(api)

    @Test
    fun `given state has no anchor position, refresh key returns null`() {
        val state = PagingState<String, Character>(emptyList(), null, PagingConfig(0), 0)
        assertNull(source.getRefreshKey(state))
    }

    @Test
    fun `given state has anchor position but no pages, refresh key returns null`() {
        val state = PagingState<String, Character>(emptyList(), 1, PagingConfig(0), 0)
        assertNull(source.getRefreshKey(state))
    }

    @Test
    fun `given state has anchor position and pages, refresh key returns value`() {
        val page = PagingSource.LoadResult.Page(listOf(character), "prevKey", null)
        val state = PagingState(listOf(page), 1, PagingConfig(0), 0)
        assertEquals("prevKey", source.getRefreshKey(state))
    }

    @Test
    fun `given initial load, default link is used and returns successfully`() {
        runTest {
            coEvery { api.getAllCharacters(DEFAULT_URL) } returns characterResponse
            val expected = PagingSource.LoadResult.Page(
                data = listOf(character),
                nextKey = null,
                prevKey = null
            )
            assertEquals(expected, source.load(getLoadParam()))
        }
    }

    @Test
    fun `given initial load, default link is used and throws exception`() {
        runTest {
            val exception = RuntimeException()
            coEvery { api.getAllCharacters(DEFAULT_URL) } throws exception
            val expected = PagingSource.LoadResult.Error<String, Character>(exception)
            assertEquals(expected, source.load(getLoadParam()))
        }
    }

    @Test
    fun `given non-initial load, default link is used and returns successfully`() {
        runTest {
            coEvery { api.getAllCharacters("next-link") } returns characterResponse
            val expected = PagingSource.LoadResult.Page(
                data = listOf(character),
                nextKey = null,
                prevKey = null
            )
            assertEquals(expected, source.load(getLoadParam("next-link")))
        }
    }

    @Test
    fun `given non-initial load, default link is used and throws exception`() {
        runTest {
            val exception = RuntimeException()
            coEvery { api.getAllCharacters("next-link") } throws exception
            val expected = PagingSource.LoadResult.Error<String, Character>(exception)
            assertEquals(expected, source.load(getLoadParam("next-link")))
        }
    }

    private fun getLoadParam(key: String? = null): PagingSource.LoadParams.Refresh<String> = PagingSource.LoadParams.Refresh<String>(
        key = key,
        loadSize = 10,
        placeholdersEnabled = false
    )
    private companion object {
        const val DEFAULT_URL = "https://rickandmortyapi.com/api/character"
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
        val characterResponse = CharacterResponse(
            info = Info(
                count = 1,
                pages = 1,
                next = null,
                prev = null,
            ),
            characters = listOf(character)
        )
    }
}