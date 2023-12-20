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
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.anvil)
    alias(libs.plugins.ksp)
}

android.namespace = "dev.kadirkid.pagingtest.character"

kotlin.explicitApi()

dependencies {
    implementation(projects.di)
    implementation(projects.di.android)
    implementation(libs.dagger.core)
    implementation(libs.dagger.android)
    kapt(libs.dagger.compiler)
    implementation(libs.paging.runtime)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.core)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlinx)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.paging.test)
    testImplementation(libs.kotlinx.coroutines.test)
}