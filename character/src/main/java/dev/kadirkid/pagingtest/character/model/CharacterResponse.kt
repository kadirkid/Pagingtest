/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CharacterResponse(
    @SerialName("info") val info: Info,
    @SerialName("results") val characters: List<Character>
)

@Serializable
public data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
