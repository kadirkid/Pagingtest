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
package dev.kadirkid.pagingtest.data

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.kadirkid.pagingtest.di.android.ViewModelKey
import com.kadirkid.rickandmortydi.AppScope
import com.squareup.anvil.annotations.ContributesMultibinding
import dev.kadirkid.pagingtest.character.model.Character
import dev.kadirkid.pagingtest.character.data.CharacterPagingSourceFactory
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ViewModelKey(MainViewModel::class)
@ContributesMultibinding(AppScope::class, boundType = ViewModel::class)
class MainViewModel @Inject constructor(private val sourceFactory: CharacterPagingSourceFactory) : ViewModel() {
    val uiState: Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { sourceFactory.create() }
    ).flow
}
