/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.design.core

import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.kadirkid.pagingtest.design.R

private val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

internal val fontFamily: FontFamily = InterFontFamily

internal val platformTextStyle: PlatformTextStyle =
    PlatformTextStyle(emojiSupportMatch = EmojiSupportMatch.Default)

private inline val DefaultFontFamily: FontFamily get() = fontFamily

private inline val DefaultPlatformTextStyle: PlatformTextStyle get() = platformTextStyle

public sealed class TypographyToken(internal val name: String, public val textStyle: TextStyle) {
    public sealed class Headline(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        public data object Large : Headline(
            name = "Headline.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                lineHeight = 40.0.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Medium : Headline(
            name = "Headline.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Small : Headline(
            name = "Headline.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )
    }

    public sealed class Title(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        public data object Large : Title(
            name = "Title.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Medium : Title(
            name = "Title.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = .2.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Small : Title(
            name = "Title.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = .1.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )
    }

    public sealed class Body(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        public data object Large : Body(
            name = "Body.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Medium : Body(
            name = "Body.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Small : Body(
            name = "Body.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )
    }

    public sealed class Label(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        public data object Large : Label(
            name = "Label.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = .1.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Medium : Label(
            name = "Label.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = .5.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )

        public data object Small : Label(
            name = "Label.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = .5.sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )
    }

    public companion object {
        public val values: List<TypographyToken> by lazy {
            listOf(
                Headline.Large,
                Headline.Medium,
                Headline.Small,
                Title.Large,
                Title.Medium,
                Title.Small,
                Body.Large,
                Body.Medium,
                Body.Small,
                Label.Large,
                Label.Medium,
                Label.Small,
            )
        }
    }
}
