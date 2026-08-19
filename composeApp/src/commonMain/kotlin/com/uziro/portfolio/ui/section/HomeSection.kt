package com.uziro.portfolio.ui.section

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.repository.keyStats
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.floatingEffect
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.animation.rememberShimmerBrush
import com.uziro.portfolio.ui.component.StatCard
import com.uziro.portfolio.ui.theme.PortfolioColors
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.profile_photo

@Composable
fun HomeSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.HeroGradient)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 36.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (layoutInfo.isExpanded) {
                    // Desktop Expanded Row: Left Bio & Headline, Right Profile Photo with Floating Effect
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Left Column: Headline, Bio & CTAs
                        Column(modifier = Modifier.weight(1.3f)) {
                            HeroBadge()
                            Spacer(modifier = Modifier.height(16.dp))
                            HeroTitle()
                            Spacer(modifier = Modifier.height(16.dp))
                            HeroBioText()
                            Spacer(modifier = Modifier.height(28.dp))
                            HeroCtaButtons(uriHandler)
                        }

                        Spacer(modifier = Modifier.width(40.dp))

                        // Right Column: Profile Picture Card with Floating Animation
                        Box(
                            modifier = Modifier
                                .weight(0.7f)
                                .floatingEffect(distanceDp = 7f, durationMs = 3200),
                            contentAlignment = Alignment.Center
                        ) {
                            ProfilePhotoAvatar(sizeDp = 280)
                        }
                    }
                } else {
                    // Mobile & Tablet Stacked with Floating Effect
                    Box(modifier = Modifier.floatingEffect(distanceDp = 5f, durationMs = 3000)) {
                        ProfilePhotoAvatar(sizeDp = if (layoutInfo.isCompact) 190 else 230)
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    HeroBadge()
                    Spacer(modifier = Modifier.height(14.dp))
                    HeroTitle(textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(14.dp))
                    HeroBioText(textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(24.dp))
                    HeroCtaButtons(uriHandler, alignCenter = true)
                }

                Spacer(modifier = Modifier.height(48.dp))

                // Key Impact Metrics Cards Grid (Material You Tonal Cards)
                if (layoutInfo.isExpanded) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        keyStats.forEach { stat ->
                            StatCard(stat = stat, modifier = Modifier.weight(1f))
                        }
                    }
                } else if (layoutInfo.isMedium) {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            StatCard(stat = keyStats[0], modifier = Modifier.weight(1f))
                            StatCard(stat = keyStats[1], modifier = Modifier.weight(1f))
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            StatCard(stat = keyStats[2], modifier = Modifier.weight(1f))
                            StatCard(stat = keyStats[3], modifier = Modifier.weight(1f))
                        }
                    }
                } else {
                    // Mobile Single Column
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        keyStats.forEach { stat ->
                            StatCard(stat = stat, modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePhotoAvatar(sizeDp: Int) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .size((sizeDp + 20).dp)
            .clip(CircleShape)
            .background(
                Brush.sweepGradient(
                    listOf(
                        PortfolioColors.Primary,
                        PortfolioColors.Secondary,
                        PortfolioColors.Tertiary,
                        PortfolioColors.Primary
                    )
                )
            )
            .rotate(rotation)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(sizeDp.dp)
                .clip(CircleShape)
                .background(PortfolioColors.Background)
                .rotate(-rotation) // Keep image upright
        ) {
            Image(
                painter = painterResource(Res.drawable.profile_photo),
                contentDescription = profileInfo.name,
                modifier = Modifier
                    .size(sizeDp.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun HeroBadge() {
    val shimmerBrush = rememberShimmerBrush()

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(PortfolioColors.PrimaryContainer.copy(alpha = 0.4f))
            .border(BorderStroke(1.dp, shimmerBrush), RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp, vertical = 7.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(PortfolioColors.EmeraldSuccess)
            )
            Text(
                text = "7+ YEARS EXPERIENCE • BANDUNG, ID",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.OnPrimaryContainer,
                letterSpacing = 1.sp
            )
        }
    }
}

@Composable
fun HeroTitle(textAlign: TextAlign = TextAlign.Start) {
    Column {
        Text(
            text = "Hi, I'm ${profileInfo.name}",
            fontSize = 38.sp,
            fontWeight = FontWeight.Black,
            color = PortfolioColors.OnSurface,
            textAlign = textAlign
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = profileInfo.title,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = PortfolioColors.Secondary,
            textAlign = textAlign
        )
    }
}

@Composable
fun HeroBioText(textAlign: TextAlign = TextAlign.Start) {
    Text(
        text = profileInfo.summary,
        fontSize = 15.sp,
        color = PortfolioColors.OnSurfaceVariant,
        lineHeight = 25.sp,
        textAlign = textAlign
    )
}

@Composable
fun HeroCtaButtons(
    uriHandler: androidx.compose.ui.platform.UriHandler,
    alignCenter: Boolean = false
) {
    Row(
        horizontalArrangement = if (alignCenter) Arrangement.Center else Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { uriHandler.openUri(profileInfo.whatsappUrl) },
            colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.interactiveHoverScale(targetScale = 1.05f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 20.dp, vertical = 14.dp)
        ) {
            Text("WhatsApp Me", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }

        OutlinedButton(
            onClick = { uriHandler.openUri(profileInfo.cvUrl) },
            border = BorderStroke(1.dp, PortfolioColors.Outline),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.interactiveHoverScale(targetScale = 1.05f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 20.dp, vertical = 14.dp)
        ) {
            Text("Download CV", color = PortfolioColors.OnSurface, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }

        OutlinedButton(
            onClick = { uriHandler.openUri(profileInfo.linkedinUrl) },
            border = BorderStroke(1.dp, PortfolioColors.Outline),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.interactiveHoverScale(targetScale = 1.05f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Text("LinkedIn", color = PortfolioColors.Secondary, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
        }
    }
}
