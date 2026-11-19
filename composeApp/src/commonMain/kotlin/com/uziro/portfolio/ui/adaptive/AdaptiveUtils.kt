package com.uziro.portfolio.ui.adaptive

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Material 3 Window Size Classes aligned with Android Adaptive Guidance.
 */
enum class WindowSizeClass {
    COMPACT,  // < 600dp
    MEDIUM,   // 600dp - 839dp
    EXPANDED  // >= 840dp
}

data class AdaptiveLayoutInfo(
    val sizeClass: WindowSizeClass,
    val maxWidth: Dp,
    val maxHeight: Dp,
    val isCompact: Boolean,
    val isMedium: Boolean,
    val isExpanded: Boolean,
    val isLarge: Boolean,
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
            width < 600.dp -> WindowSizeClass.COMPACT
            width < 840.dp -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        val horizontalPadding = when (sizeClass) {
            WindowSizeClass.COMPACT -> 16.dp
            WindowSizeClass.MEDIUM -> 24.dp
            WindowSizeClass.EXPANDED -> 32.dp
        }

        val gridColumns = when {
            width < 600.dp -> 1
            width < 960.dp -> 2
            else -> 3
        }

        val info = AdaptiveLayoutInfo(
            sizeClass = sizeClass,
            maxWidth = width,
            maxHeight = height,
            isCompact = sizeClass == WindowSizeClass.COMPACT,
            isMedium = sizeClass == WindowSizeClass.MEDIUM,
            isExpanded = sizeClass == WindowSizeClass.EXPANDED,
            isLarge = width >= 1100.dp,
            horizontalPadding = horizontalPadding,
            gridColumns = gridColumns
        )

        content(info)
    }
}
