/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val exclusions = arrayOf(
            "**/build/**",
            "**/.*/**",
        )
        with(target) {
            pluginManager.apply("com.diffplug.spotless")
            extensions.configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt")
                    targetExclude("${layout.buildDirectory}/**/*.kt", "**/copyright.kt", *exclusions)
                    licenseHeaderFile(rootProject.file("$rootDir/spotless/copyright.kt"))
                    trimTrailingWhitespace()
                    endWithNewline()
                }
                format("kts") {
                    target("**/*.kts")
                    targetExclude("${layout.buildDirectory}/**/*.kts", "**/copyright.kts", *exclusions)
                    // Look for the first line that doesn't have a block comment (assumed to be the license)
                    licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
                }
                format("xml") {
                    target("**/*.xml")
                    targetExclude("**/build/**/*.xml", "**/copyright.xml", *exclusions)
                    // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
                    licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
                }
            }
        }
    }
}
