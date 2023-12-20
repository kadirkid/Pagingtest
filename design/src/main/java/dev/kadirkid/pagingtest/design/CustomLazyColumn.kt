/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.design

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
public fun CustomLazyColumn(
    modifier: Modifier = Modifier,
    content: LazyListScope.(Modifier) -> Unit,
) {
    var largestWidth by remember { mutableStateOf(0) }
    LazyColumn(modifier = modifier.padding(vertical = 8.dp)) {
        content(
//            Modifier.layout { measurable, constraints ->
//                val oldPlaceable = measurable.measure(constraints)
//                if (oldPlaceable.width > largestWidth) largestWidth = oldPlaceable.width
//
//                val newPlaceable = measurable.measure(
//                    constraints.copy(
//                        minWidth = largestWidth,
//                        maxWidth = largestWidth,
//                    ),
//                )
//                layout(newPlaceable.width, newPlaceable.height) {
//                    newPlaceable.place(0, 0)
//                }
//            },
            Modifier,
        )
    }
}
