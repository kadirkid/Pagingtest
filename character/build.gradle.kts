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
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlinx)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.paging.test)
    testImplementation(libs.kotlinx.coroutines.test)
}