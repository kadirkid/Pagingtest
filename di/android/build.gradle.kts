/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android.namespace = "dev.kadirkid.pagingtest.di.android"

dependencies {
    api(libs.androidx.fragment)
    api(libs.dagger.core)
    api(libs.androidx.activity)
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.process)
    api(libs.androidx.lifecycle.runtime)
}