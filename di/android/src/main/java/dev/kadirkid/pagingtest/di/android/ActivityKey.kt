/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.di.android

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A Dagger multi-binding key used for registering a [Activity] into the top level dagger graphs.
 */
@MapKey
annotation class ActivityKey(val value: KClass<out Activity>)
