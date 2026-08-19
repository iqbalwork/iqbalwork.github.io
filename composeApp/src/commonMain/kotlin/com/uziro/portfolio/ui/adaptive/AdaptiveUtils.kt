package com.uziro.portfolio.ui.adaptive

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSizeClass {
    COMPACT, // Phone (< 640dp)
    MEDIUM,  // Tablet / Foldable (640dp - 1024dp)
    EXPANDED // Desktop / Large Screen (> 1024dp)
}

data class AdaptiveLayoutInfo(
    val sizeClass: WindowSizeClass,
    val maxWidth: Dp,
    val maxHeight: Dp,
    val isCompact: Boolean,
    val isMedium: Boolean,
    val isExpanded: Boolean,
    val horizontalPadding: Dp,
    val gridColumns: Int
)

@Composable
fun AdaptiveBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxWithConstraintsScope.(AdaptiveLayoutInfo) -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        val width = maxWidth
        val height = maxHeight

        val sizeClass = when {
            width < 640.dp -> WindowSizeClass.COMPACT
            width < 1024.dp -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        val horizontalPadding = when (sizeClass) {
            WindowSizeClass.COMPACT -> 16.dp
            WindowSizeClass.MEDIUM -> 32.dp
            WindowSizeClass.EXPANDED -> 64.dp
        }

        val gridColumns = when (sizeClass) {
            WindowSizeClass.COMPACT -> 1
            WindowSizeClass.MEDIUM -> 2
            WindowSizeClass.EXPANDED -> 3
        }

        val info = AdaptiveLayoutInfo(
            sizeClass = sizeClass,
            maxWidth = width,
            maxHeight = height,
            isCompact = sizeClass == WindowSizeClass.COMPACT,
            isMedium = sizeClass == WindowSizeClass.MEDIUM,
            isExpanded = sizeClass == WindowSizeClass.EXPANDED,
            horizontalPadding = horizontalPadding,
            gridColumns = gridColumns
        )

        content(info)
    }
}
