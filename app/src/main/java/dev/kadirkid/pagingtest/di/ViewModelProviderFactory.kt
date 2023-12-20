/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kadirkid.rickandmortydi.AppScope
import com.kadirkid.rickandmortydi.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Provider

/** A factory that will provide [ViewModels][ViewModel] using their Dagger provider. */
@ContributesBinding(AppScope::class, boundType = ViewModelProvider.Factory::class)
@SingleIn(AppScope::class)
class PagingTestViewModelProviderFactory @Inject constructor(
    private val modelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val modelProvider = modelProviders[modelClass]
            ?: throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        @Suppress("UNCHECKED_CAST") return modelProvider.get() as T
    }
}
