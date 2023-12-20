/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import dev.kadirkid.pagingtest.character.model.Character

@Composable
internal fun CharacterPage(state: LazyPagingItems<Character>, modifier: Modifier = Modifier) {
    when (state.loadState.refresh) {
        is LoadState.Error -> Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val error = (state.loadState.refresh as LoadState.Error).error
            Text(error.message ?: error.localizedMessage)
        }

        LoadState.Loading -> Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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
