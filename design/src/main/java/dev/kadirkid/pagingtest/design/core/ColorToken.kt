/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.design.core

import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

public sealed interface ColorToken {
    public val color: Color
}

@JvmInline
public value class TextColor internal constructor(override val color: Color) : ColorToken

@JvmInline
public value class BackgroundColor internal constructor(override val color: Color) : ColorToken {
    public companion object {
        public val Unspecified: BackgroundColor = BackgroundColor(Color.Unspecified)
    }
}
