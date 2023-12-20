/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.kadirkid.pagingtest.character.model.Character

public class CharacterPagingSource(
    private val api: CharacterApi
): PagingSource<String, Character>() {
    override fun getRefreshKey(state: PagingState<String, Character>): String? =
        state.anchorPosition?.let { state.closestPageToPosition(anchorPosition = it) }?.prevKey

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> =
        runCatching { api.getAllCharacters(params.key ?: DEFAULT_URL).also { println("-----------> RRR: $it") } }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it.characters,
                    nextKey = it.info.next,
                    prevKey = it.info.prev
                )
            },
            onFailure = { LoadResult.Error(it) }
        )

    private companion object {
        const val DEFAULT_URL = "https://rickandmortyapi.com/api/character"
    }
}
