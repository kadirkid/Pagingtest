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
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
