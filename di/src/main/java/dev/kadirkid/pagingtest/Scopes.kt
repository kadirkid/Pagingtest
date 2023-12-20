/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package com.kadirkid.rickandmortydi

import javax.inject.Scope
import kotlin.reflect.KClass

abstract class AppScope private constructor()

@Scope
annotation class SingleIn(val scope: KClass<*>)
