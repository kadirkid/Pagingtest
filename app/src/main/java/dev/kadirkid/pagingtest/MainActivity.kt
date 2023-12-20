/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.paging.compose.collectAsLazyPagingItems
import dev.kadirkid.pagingtest.di.android.ActivityKey
import dev.kadirkid.pagingtest.di.android.get
import com.kadirkid.rickandmortydi.AppScope
import com.squareup.anvil.annotations.ContributesMultibinding
import dev.kadirkid.pagingtest.data.MainViewModel
import dev.kadirkid.pagingtest.design.PagingTestTheme
import dev.kadirkid.pagingtest.ui.CharacterPage
import javax.inject.Inject

@ActivityKey(MainActivity::class)
@ContributesMultibinding(AppScope::class, boundType = Activity::class)
class MainActivity @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy { viewModelFactory.get(this@MainActivity) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingTestTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val state = viewModel.uiState.collectAsLazyPagingItems()
                    CharacterPage(state)
                }
            }
        }
    }
}
