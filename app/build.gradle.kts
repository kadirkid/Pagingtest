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
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.anvil)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.kadirkid.pagingtest"

    defaultConfig {
        applicationId = "dev.kadirkid.pagingtest"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures.compose = true
    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

anvil {
    generateDaggerFactories.set(false)
    syncGeneratedSources.set(true)
}

dependencies {
    implementation(projects.design)
    implementation(projects.di)
    implementation(projects.character)
    implementation(projects.di.android)
    implementation(libs.dagger.core)
    implementation(libs.dagger.android)
    kapt(libs.dagger.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.paging)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.kotlinx)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
    implementation(libs.coil.compose)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.paging.test)
    testImplementation(libs.kotlinx.coroutines.test)
}