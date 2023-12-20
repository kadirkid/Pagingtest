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
