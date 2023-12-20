/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
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
