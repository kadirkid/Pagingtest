/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
public data class Character(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: Status,
    @SerialName("species") val species: String,
    @SerialName("type") val type: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: Location,
    @SerialName("location") val location: Location,
    @SerialName("image") val image: String,
    @SerialName("episode") val episode: List<String>,
    @SerialName("url") val url: String,
    @SerialName("created") val created: String
) {
    @Serializable
    public enum class Status {
        @SerialName("Alive")
        ALIVE,
        @SerialName("Dead")
        DEAD,
        @SerialName("unknown")
        UNKNOWN
    }
}
