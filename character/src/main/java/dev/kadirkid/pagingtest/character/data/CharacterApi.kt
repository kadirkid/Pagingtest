/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.data

import dev.kadirkid.pagingtest.character.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Url

public interface CharacterApi {
    @GET
    public suspend fun getAllCharacters(@Url url: String): CharacterResponse
}
