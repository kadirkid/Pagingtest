/**
 * Copyright 2023 Abdulahi Osoble
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.kadirkid.pagingtest.character.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.kadirkid.pagingtest.character.model.Character

internal class CharacterPagingSource(
    private val api: CharacterApi
): PagingSource<String, Character>() {
    override fun getRefreshKey(state: PagingState<String, Character>): String? =
        state.anchorPosition?.let { state.closestPageToPosition(anchorPosition = it) }?.prevKey

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> =
        runCatching { api.getAllCharacters(params.key ?: DEFAULT_URL) }.fold(
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
