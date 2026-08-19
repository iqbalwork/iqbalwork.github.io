package com.uziro.portfolio.ui.section

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.theme.PortfolioColors

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    onNavigateToIndex: (Int) -> Unit = {}
) {
    val uriHandler = LocalUriHandler.current

    // Pulsing beacon for available badge
    val transition = rememberInfiniteTransition()
    val pulseAlpha by transition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    AdaptiveBox(modifier = modifier) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.BgGlass)
                .border(0.5.dp, PortfolioColors.OutlineVariant)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo & Status Indicator
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .interactiveHoverScale(targetScale = 1.04f)
                        .clickable { onNavigateToIndex(0) }
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(PortfolioColors.Primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "IF",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Column {
                        Text(
                            text = profileInfo.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = PortfolioColors.OnSurface
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(PortfolioColors.EmeraldSuccess.copy(alpha = pulseAlpha))
                            )
                            Text(
                                text = "Available for KMP / Android Roles",
                                fontSize = 11.sp,
                                color = PortfolioColors.EmeraldSuccess,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                // Desktop / Tablet Navigation Links
                if (!layoutInfo.isCompact) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavLink("Home") { onNavigateToIndex(0) }
                        NavLink("Experience") { onNavigateToIndex(1) }
                        NavLink("Projects") { onNavigateToIndex(2) }
                        NavLink("Skills") { onNavigateToIndex(3) }
                        NavLink("Contact") { onNavigateToIndex(4) }

                        Button(
                            onClick = { uriHandler.openUri(profileInfo.cvUrl) },
                            colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.interactiveHoverScale(targetScale = 1.05f),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 10.dp)
                        ) {
                            Text(
                                text = "Download CV",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                } else {
                    // Mobile Quick CTA
                    Button(
                        onClick = { uriHandler.openUri(profileInfo.whatsappUrl) },
                        colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text("Connect", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun NavLink(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        color = PortfolioColors.OnSurfaceVariant,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .interactiveHoverScale(targetScale = 1.08f)
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 6.dp)
    )
}
