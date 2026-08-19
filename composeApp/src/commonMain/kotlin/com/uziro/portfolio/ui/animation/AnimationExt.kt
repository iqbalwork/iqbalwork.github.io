package com.uziro.portfolio.ui.animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.uziro.portfolio.ui.theme.PortfolioColors
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun rememberItemVisible(
    key: Any,
    listState: LazyListState
): Boolean {
    var isVisible by remember(key) { mutableStateOf(false) }

    LaunchedEffect(listState, key) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.any { it.key == key }
        }
            .distinctUntilChanged()
            .collect { currentlyVisible ->
                if (currentlyVisible) {
                    isVisible = true
                }
            }
    }

    return isVisible
}

/**
 * Animated Shimmer Gradient Brush that sweeps continuously
 */
@Composable
fun rememberShimmerBrush(
    colors: List<Color> = listOf(
        PortfolioColors.Primary.copy(alpha = 0.6f),
        PortfolioColors.Secondary.copy(alpha = 0.9f),
        PortfolioColors.Tertiary.copy(alpha = 0.6f),
        PortfolioColors.Primary.copy(alpha = 0.6f)
    )
): Brush {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    return Brush.linearGradient(
        colors = colors,
        start = Offset(translateAnim - 500f, translateAnim - 500f),
        end = Offset(translateAnim + 500f, translateAnim + 500f)
    )
}

/**
 * Animated Floating Up-Down Translation
 */
@Composable
fun Modifier.floatingEffect(
    distanceDp: Float = 8f,
    durationMs: Int = 3000
): Modifier {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetY by infiniteTransition.animateFloat(
        initialValue = -distanceDp,
        targetValue = distanceDp,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMs, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return this.graphicsLayer {
        translationY = offsetY
    }
}

/**
 * Animated Pulsing Scale & Alpha Effect
 */
@Composable
fun Modifier.pulsingGlowEffect(
    minScale: Float = 0.96f,
    maxScale: Float = 1.04f,
    durationMs: Int = 2000
): Modifier {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMs, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return this.graphicsLayer {
        scaleX = scale
        scaleY = scale
    }
}

/**
 * Interactive Scale effect on Hover / Press
 */
@Composable
fun Modifier.interactiveHoverScale(
    targetScale: Float = 1.025f,
    onClick: (() -> Unit)? = null
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = when {
            isPressed -> 0.98f
            isHovered -> targetScale
            else -> 1.0f
        },
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 400f)
    )

    return this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .then(
            if (onClick != null) {
                Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick
                )
            } else {
                Modifier
            }
        )
}
