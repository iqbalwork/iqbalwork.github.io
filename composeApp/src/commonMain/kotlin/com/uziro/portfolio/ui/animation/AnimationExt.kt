package com.uziro.portfolio.ui.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Tactile Material 3 hover & press feedback without excessive decorative oscillation.
 */
@Composable
fun Modifier.interactiveHoverScale(
    targetScale: Float = 1.015f,
    onClick: (() -> Unit)? = null
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = when {
            isPressed -> 0.985f
            isHovered -> targetScale
            else -> 1.0f
        },
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 450f)
    )

    val hoverMod = this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .hoverable(interactionSource = interactionSource)

    return if (onClick != null) {
        hoverMod.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        )
    } else {
        hoverMod
    }
}
