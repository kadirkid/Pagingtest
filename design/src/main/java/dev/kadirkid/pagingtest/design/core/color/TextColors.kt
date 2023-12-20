/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.design.core.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.kadirkid.pagingtest.design.core.TextColor
import dev.kadirkid.pagingtest.design.md_theme_dark_inversePrimary
import dev.kadirkid.pagingtest.design.md_theme_dark_primary
import dev.kadirkid.pagingtest.design.md_theme_dark_secondary
import dev.kadirkid.pagingtest.design.md_theme_dark_tertiary
import dev.kadirkid.pagingtest.design.md_theme_light_inversePrimary
import dev.kadirkid.pagingtest.design.md_theme_light_primary
import dev.kadirkid.pagingtest.design.md_theme_light_secondary
import dev.kadirkid.pagingtest.design.md_theme_light_tertiary

@Immutable
public class TextColors internal constructor(
    public val primary: TextColor,
    public val secondary: TextColor,
    public val tertiary: TextColor,
    public val primaryInverse: TextColor,
)

public val LocalTextColors: ProvidableCompositionLocal<TextColors> =
    staticCompositionLocalOf { error("No TextColors provided") }

internal fun lightTextColors(): TextColors = TextColors(
    primary = TextColor(md_theme_light_primary),
    secondary = TextColor(md_theme_light_secondary),
    tertiary = TextColor(md_theme_light_tertiary),
    primaryInverse = TextColor(md_theme_light_inversePrimary),
)

internal fun darkTextColors(): TextColors = TextColors(
    primary = TextColor(md_theme_dark_primary),
    secondary = TextColor(md_theme_dark_secondary),
    tertiary = TextColor(md_theme_dark_tertiary),
    primaryInverse = TextColor(md_theme_dark_inversePrimary),
)

internal fun TextColors.withNames() = buildList {
    add(Pair("primary", primary))
    add(Pair("secondary", secondary))
    add(Pair("tertiary", tertiary))
    add(Pair("primaryInverse", primaryInverse))
}
