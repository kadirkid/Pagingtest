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
package dev.kadirkid.pagingtest.character.di

import com.kadirkid.rickandmortydi.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.kadirkid.pagingtest.character.data.CharacterApi
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactory
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactoryImpl
import retrofit2.Retrofit
import retrofit2.create

@Module
@ContributesTo(AppScope::class)
public interface CharacterModule {
    @Provides
    public fun provideCharacterApi(): CharacterApi = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .build()
        .create()

    @Provides
    public fun provideCharacterPagingSourceFactory(api: CharacterApi): CharacterPagingSourceFactory = CharacterPagingSourceFactoryImpl(api)
}
