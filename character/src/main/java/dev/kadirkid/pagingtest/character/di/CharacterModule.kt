/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.character.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kadirkid.rickandmortydi.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.kadirkid.pagingtest.character.data.CharacterApi
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactory
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactoryImpl
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

@Module
@ContributesTo(AppScope::class)
public object CharacterModule {
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    public fun provideCharacterApi(): CharacterApi = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create()

    @Provides
    public fun provideCharacterPagingSourceFactory(api: CharacterApi): CharacterPagingSourceFactory = CharacterPagingSourceFactoryImpl(api)
}
