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
