package com.uziro.portfolio.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.OpenInNew
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material.icons.rounded.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.ExperienceItem
import com.uziro.portfolio.data.MetricStat
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.theme.statusColors
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.compose_multiplatform

@Composable
fun SectionHeader(
    eyebrow: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    alignCenter: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = if (alignCenter) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ) {
            Text(
                text = eyebrow,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.widthIn(max = 680.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

/**
 * Tonal M3 stat card cycling subtly across semantic container roles.
 */
@Composable
fun StatCard(
    stat: MetricStat,
    toneIndex: Int,
    modifier: Modifier = Modifier
) {
    val (containerColor, contentColor, accentColor) = when (toneIndex % 4) {
        0 -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
            MaterialTheme.colorScheme.primary
        )
        1 -> Triple(
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.onSecondaryContainer,
            MaterialTheme.colorScheme.secondary
        )
        2 -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
            MaterialTheme.colorScheme.tertiary
        )
        else -> Triple(
            MaterialTheme.colorScheme.surfaceContainerHigh,
            MaterialTheme.colorScheme.onSurface,
            MaterialTheme.colorScheme.primary
        )
    }

    Card(
        modifier = modifier.interactiveHoverScale(targetScale = 1.02f),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stat.value,
                style = MaterialTheme.typography.headlineLarge,
                color = contentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stat.label,
                style = MaterialTheme.typography.titleMedium,
                color = contentColor
            )
            Text(
                text = stat.description,
                style = MaterialTheme.typography.bodySmall,
                color = contentColor.copy(alpha = 0.85f)
            )
            Spacer(modifier = Modifier.weight(1f, fill = true))
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.65f),
                contentColor = accentColor
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Verified,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = stat.highlight,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExperienceCard(
    experience: ExperienceItem,
    initiallyExpanded: Boolean = true,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(initiallyExpanded) }
    val chevronRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(250)
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            val stackPeriod = maxWidth < 520.dp

            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { isExpanded = !isExpanded }
                        .padding(vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(44.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.Work,
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = experience.role,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${experience.company} · ${experience.location}",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            if (stackPeriod) {
                                Spacer(modifier = Modifier.height(2.dp))
                                ExperiencePeriodPill(period = experience.period)
                            }
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        if (!stackPeriod) {
                            ExperiencePeriodPill(period = experience.period)
                        }

                        IconButton(onClick = { isExpanded = !isExpanded }) {
                            Icon(
                                imageVector = Icons.Rounded.ExpandMore,
                                contentDescription = if (isExpanded) "Collapse details" else "Expand details",
                                modifier = Modifier.rotate(chevronRotation),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = experience.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (experience.metrics.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(14.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        experience.metrics.forEach { metric ->
                            TonalMetricBadge(text = metric)
                        }
                    }
                }

                AnimatedVisibility(
                    visible = isExpanded,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        Spacer(modifier = Modifier.height(16.dp))

                        if (experience.phases.isNotEmpty()) {
                            Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                                experience.phases.forEachIndexed { phaseIdx, phase ->
                                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                        if (stackPeriod) {
                                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                                Text(
                                                    text = phase.title,
                                                    style = MaterialTheme.typography.titleSmall,
                                                    color = MaterialTheme.colorScheme.primary
                                                )
                                                PhasePeriodBadge(period = phase.period, isPrimary = phaseIdx == 0)
                                            }
                                        } else {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = phase.title,
                                                    style = MaterialTheme.typography.titleSmall,
                                                    color = MaterialTheme.colorScheme.primary,
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .padding(end = 12.dp)
                                                )
                                                PhasePeriodBadge(period = phase.period, isPrimary = phaseIdx == 0)
                                            }
                                        }
                                        AchievementList(achievements = phase.achievements)
                                    }
                                }
                            }
                        } else {
                            AchievementList(achievements = experience.achievements)
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            experience.technologies.forEach { tech ->
                                TonalTag(text = tech)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PhasePeriodBadge(
    period: String,
    isPrimary: Boolean
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (isPrimary) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceContainerHigh
        },
        contentColor = if (isPrimary) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
    ) {
        Text(
            text = period,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun ExperiencePeriodPill(period: String) {
    Surface(
        shape = CircleShape,
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Schedule,
                contentDescription = null,
                modifier = Modifier.size(13.dp)
            )
            Text(
                text = period,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
private fun AchievementList(achievements: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        achievements.forEach { achievement ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .size(16.dp)
                )
                Text(
                    text = achievement,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun TonalMetricBadge(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.statusColors.successContainer,
        contentColor = MaterialTheme.statusColors.onSuccessContainer
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}

/**
 * Non-interactive tonal tag for technology stack / skills (distinct from interactive FilterChips).
 */
@Composable
fun TonalTag(
    text: String,
    modifier: Modifier = Modifier,
    emphasized: Boolean = false
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = if (emphasized) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceContainerHighest
        },
        contentColor = if (emphasized) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(
    project: Project,
    onViewDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Card(
        onClick = onViewDetail,
        modifier = modifier
            .fillMaxWidth()
            .interactiveHoverScale(targetScale = 1.015f),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        val isLogoArtwork = project.image == Res.drawable.compose_multiplatform
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(176.dp)
                    .background(
                        if (isLogoArtwork) {
                            MaterialTheme.colorScheme.surfaceContainerHighest
                        } else {
                            MaterialTheme.colorScheme.surfaceContainerHigh
                        }
                    )
            ) {
                if (isLogoArtwork) {
                    Image(
                        painter = painterResource(project.image),
                        contentDescription = project.title,
                        modifier = Modifier
                            .size(96.dp)
                            .align(Alignment.Center),
                        contentScale = ContentScale.Fit
                    )
                } else {
                    Image(
                        painter = painterResource(project.image),
                        contentDescription = project.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(14.dp)
                ) {
                    Text(
                        text = project.category,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = project.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    minLines = 3,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    project.techStack.take(3).forEach { tech ->
                        TonalTag(text = tech.substringBefore(" ("))
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = onViewDetail,
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                        modifier = Modifier.defaultMinSize(minHeight = 40.dp)
                    ) {
                        Text("Case study")
                        Spacer(modifier = Modifier.size(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    if (project.playStoreUrl != null) {
                        FilledTonalButton(
                            onClick = { uriHandler.openUri(project.playStoreUrl) },
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            modifier = Modifier.defaultMinSize(minHeight = 40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Shop,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.size(6.dp))
                            Text("Play Store", maxLines = 1)
                        }
                    } else if (project.githubUrl != null) {
                        OutlinedButton(
                            onClick = { uriHandler.openUri(project.githubUrl) },
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            modifier = Modifier.defaultMinSize(minHeight = 40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Code,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.size(6.dp))
                            Text("GitHub", maxLines = 1)
                        }
                    } else if (project.url != null) {
                        OutlinedButton(
                            onClick = { uriHandler.openUri(project.url) },
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            modifier = Modifier.defaultMinSize(minHeight = 40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.OpenInNew,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.size(6.dp))
                            Text("Open", maxLines = 1)
                        }
                    }
                }
            }
        }
    }
}
