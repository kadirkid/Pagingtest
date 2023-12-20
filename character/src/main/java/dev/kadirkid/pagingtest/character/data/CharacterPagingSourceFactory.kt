/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.data

import androidx.paging.PagingSource
import dev.kadirkid.pagingtest.character.model.Character
import javax.inject.Inject

public interface CharacterPagingSourceFactory {
    public fun create(): PagingSource<String, Character>
}

public class CharacterPagingSourceFactoryImpl @Inject constructor(
    private val api: CharacterApi
) : CharacterPagingSourceFactory {
    override fun create(): PagingSource<String, Character> = CharacterPagingSource(api)
}
