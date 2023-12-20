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
package dev.kadirkid.pagingtest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import dev.kadirkid.pagingtest.character.model.Character

@Composable
internal fun CharacterPage(state: LazyPagingItems<Character>, modifier: Modifier = Modifier) {
    when (state.loadState.refresh) {
        is LoadState.Error -> TODO()
        LoadState.Loading -> Column {
            CircularProgressIndicator(strokeWidth = 4.dp, modifier = modifier.size(24.dp))
        }

        is LoadState.NotLoading -> LazyColumn(modifier = modifier.fillMaxSize()) {
            items(state.itemCount) {
                val character = state[it] ?: return@items
                CharacterCard(character)
            }
        }
    }
}
