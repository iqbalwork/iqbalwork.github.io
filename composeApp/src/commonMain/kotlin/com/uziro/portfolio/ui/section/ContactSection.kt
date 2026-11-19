package com.uziro.portfolio.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.automirrored.rounded.OpenInNew
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.repository.additionalProfileInfo
import com.uziro.portfolio.data.repository.educationInfo
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.data.repository.socialMediaList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.component.SectionHeader
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp)
        ) {
            SectionHeader(
                eyebrow = "Get in Touch",
                title = "Let's Build Something Exceptional",
                subtitle = "Open to Senior Android, Android Lead, and Kotlin Multiplatform (KMP) roles, distributed team collaboration, or technical consulting."
            )

            if (layoutInfo.isExpanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    ContactCard(
                        modifier = Modifier.weight(1.1f),
                        uriHandler = uriHandler
                    )

                    Column(
                        modifier = Modifier.weight(0.9f),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        EducationCard()
                        PlayPortfolioCard(uriHandler = uriHandler)
                        SocialMediaCard(uriHandler = uriHandler)
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    ContactCard(
                        modifier = Modifier.fillMaxWidth(),
                        uriHandler = uriHandler
                    )
                    EducationCard()
                    PlayPortfolioCard(uriHandler = uriHandler)
                    SocialMediaCard(uriHandler = uriHandler)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "© 2026 Iqbal Fauzi",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ) {
                    Text(
                        text = "Compose Multiplatform · Material 3",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ContactCard(
    modifier: Modifier = Modifier,
    uriHandler: UriHandler
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Direct Contact",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = additionalProfileInfo.asyncCollaboration,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(4.dp))

            ContactListItem(
                icon = Icons.Rounded.Mail,
                overline = "Email",
                headline = profileInfo.email,
                onClick = { uriHandler.openUri("mailto:${profileInfo.email}") }
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            ContactListItem(
                icon = Icons.Rounded.Call,
                overline = "Phone / WhatsApp",
                headline = profileInfo.phone,
                onClick = { uriHandler.openUri(profileInfo.whatsappUrl) }
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            ContactListItem(
                icon = Icons.Rounded.LocationOn,
                overline = "Location",
                headline = profileInfo.location,
                onClick = null
            )

            Spacer(modifier = Modifier.height(12.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { uriHandler.openUri(profileInfo.whatsappUrl) },
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.Chat,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Chat on WhatsApp")
                }

                FilledTonalButton(
                    onClick = { uriHandler.openUri(profileInfo.cvUrl) },
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Description,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("View CV")
                }
            }
        }
    }
}

@Composable
private fun ContactListItem(
    icon: ImageVector,
    overline: String,
    headline: String,
    onClick: (() -> Unit)?
) {
    ListItem(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .then(
                if (onClick != null) {
                    Modifier.clickable(role = Role.Button, onClick = onClick)
                } else {
                    Modifier
                }
            ),
        colors = ListItemDefaults.colors(containerColor = Color.Transparent),
        leadingContent = {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        },
        overlineContent = { Text(overline) },
        headlineContent = {
            Text(
                text = headline,
                style = MaterialTheme.typography.titleSmall
            )
        },
        trailingContent = if (onClick != null) {
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.OpenInNew,
                    contentDescription = "Open $overline",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(18.dp)
                )
            }
        } else {
            null
        }
    )
}

@Composable
private fun EducationCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Rounded.School,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column {
                    Text(
                        text = "Education",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Text(
                        text = educationInfo.degree,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Text(
                text = "${educationInfo.institution} · ${educationInfo.location}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = educationInfo.period,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = educationInfo.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun PlayPortfolioCard(uriHandler: UriHandler) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Google Play Portfolio",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            additionalProfileInfo.playStoreLinks.forEachIndexed { index, item ->
                if (index > 0) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                }
                ListItem(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .clickable(role = Role.Button) { uriHandler.openUri(item.url) },
                    colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                    leadingContent = {
                        Surface(
                            shape = MaterialTheme.shapes.small,
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.Shop,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    },
                    headlineContent = { Text(item.title, style = MaterialTheme.typography.titleSmall) },
                    supportingContent = { Text(item.subtitle, style = MaterialTheme.typography.bodySmall) },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.OpenInNew,
                            contentDescription = "Open ${item.title} on Google Play",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SocialMediaCard(uriHandler: UriHandler) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Connect Across Platforms",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
                val badgeBg = if (isDark) {
                    Color(0xFFEDF2EE)
                } else {
                    MaterialTheme.colorScheme.surfaceContainerHigh
                }
                socialMediaList.forEach { social ->
                    Surface(
                        onClick = { uriHandler.openUri(social.url) },
                        shape = CircleShape,
                        color = badgeBg,
                        modifier = Modifier
                            .size(48.dp)
                            .interactiveHoverScale(targetScale = 1.08f)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(social.icon),
                                contentDescription = social.name,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
