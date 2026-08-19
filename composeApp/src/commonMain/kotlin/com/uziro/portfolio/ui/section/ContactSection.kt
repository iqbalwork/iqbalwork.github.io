package com.uziro.portfolio.ui.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.repository.educationInfo
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.data.repository.socialMediaList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.theme.PortfolioColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.Surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 50.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    tag = "Get In Touch",
                    title = "Let's Build Something Exceptional",
                    subtitle = "Open to Android Lead, Senior Android, and Kotlin Multiplatform (KMP) opportunities or technical consulting."
                )

                if (layoutInfo.isExpanded) {
                    // Desktop Side-by-Side: Contact Cards on Left, Education & Socials on Right
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        // Left: Direct Contact Card
                        ContactCard(
                            modifier = Modifier.weight(1.2f),
                            uriHandler = uriHandler
                        )

                        // Right: Education & Additional Info
                        Column(
                            modifier = Modifier.weight(0.8f),
                            verticalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            EducationCard()
                            SocialMediaGrid(uriHandler)
                        }
                    }
                } else {
                    // Mobile & Tablet Stacked
                    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        ContactCard(
                            modifier = Modifier.fillMaxWidth(),
                            uriHandler = uriHandler
                        )
                        EducationCard()
                        SocialMediaGrid(uriHandler)
                    }
                }

                Spacer(modifier = Modifier.height(48.dp))
                HorizontalDivider(color = PortfolioColors.OutlineVariant)
                Spacer(modifier = Modifier.height(24.dp))

                // Footer Bottom Note
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "© 2026 Iqbal Fauzi. All rights reserved.",
                        fontSize = 12.sp,
                        color = PortfolioColors.TextMuted
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(PortfolioColors.PrimaryContainer.copy(alpha = 0.35f))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "Crafted with Compose Multiplatform",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = PortfolioColors.OnPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    uriHandler: androidx.compose.ui.platform.UriHandler
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(26.dp)
    ) {
        Column {
            Text(
                text = "DIRECT CONTACT CHANNELS",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.Primary,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            ContactRow(
                label = "Email Address",
                value = profileInfo.email,
                onClick = { uriHandler.openUri("mailto:${profileInfo.email}") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ContactRow(
                label = "Phone / WhatsApp",
                value = profileInfo.phone,
                onClick = { uriHandler.openUri(profileInfo.whatsappUrl) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ContactRow(
                label = "Location",
                value = profileInfo.location,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { uriHandler.openUri(profileInfo.whatsappUrl) },
                    colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .interactiveHoverScale(targetScale = 1.04f)
                ) {
                    Text("Chat on WhatsApp", fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = { uriHandler.openUri(profileInfo.cvUrl) },
                    border = BorderStroke(1.dp, PortfolioColors.Outline),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .interactiveHoverScale(targetScale = 1.04f)
                ) {
                    Text("Download CV", color = PortfolioColors.OnSurface, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ContactRow(label: String, value: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(PortfolioColors.SurfaceContainerHigh)
            .interactiveHoverScale(targetScale = 1.02f)
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            color = PortfolioColors.OnSurfaceVariant,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = PortfolioColors.OnSurface
        )
    }
}

@Composable
fun EducationCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(22.dp)
    ) {
        Column {
            Text(
                text = "EDUCATION",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.Secondary,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = educationInfo.degree,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.OnSurface
            )
            Text(
                text = "${educationInfo.institution} • ${educationInfo.location}",
                fontSize = 13.sp,
                color = PortfolioColors.Primary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = educationInfo.period,
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                color = PortfolioColors.TextMuted
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = educationInfo.description,
                fontSize = 13.sp,
                color = PortfolioColors.OnSurfaceVariant,
                lineHeight = 19.sp
            )
        }
    }
}

@Composable
fun SocialMediaGrid(uriHandler: androidx.compose.ui.platform.UriHandler) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(22.dp)
    ) {
        Column {
            Text(
                text = "CONNECT ACROSS PLATFORMS",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.TextMuted,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                socialMediaList.take(5).forEach { social ->
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(PortfolioColors.SurfaceContainerHigh)
                            .border(1.dp, PortfolioColors.OutlineVariant, CircleShape)
                            .interactiveHoverScale(targetScale = 1.15f)
                            .clickable { uriHandler.openUri(social.url) }
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(social.icon),
                            contentDescription = social.name,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}
