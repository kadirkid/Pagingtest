/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
}

group = "dev.kadirkid.pagingtest.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
    compileOnly("com.diffplug.spotless:spotless-plugin-gradle:6.21.0")
}
gradlePlugin {
    plugins {
        register("spotless") {
            id = "pagingtest.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}