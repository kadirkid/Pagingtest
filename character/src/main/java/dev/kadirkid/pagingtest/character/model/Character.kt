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
    @SerialName("origin") val origin: Origin,
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
