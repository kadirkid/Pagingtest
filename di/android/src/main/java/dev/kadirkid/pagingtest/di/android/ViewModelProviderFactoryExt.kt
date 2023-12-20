/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.di.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Returns a [ViewModel] using its Dagger provider.
 *
 * @throws IllegalArgumentException if the [ViewModel] is not found.
 */
inline fun <reified T : ViewModel> ViewModelProvider.Factory.get(owner: ViewModelStoreOwner): T {
    return ViewModelProvider(owner, this)[T::class.java]
}
