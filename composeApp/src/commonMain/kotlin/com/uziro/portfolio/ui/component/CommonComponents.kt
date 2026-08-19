package com.uziro.portfolio.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.uziro.portfolio.data.ExperienceItem
import com.uziro.portfolio.data.MetricStat
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.animation.rememberShimmerBrush
import com.uziro.portfolio.ui.theme.PortfolioColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun SectionHeader(
    tag: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    alignCenter: Boolean = false
) {
    val shimmerBrush = rememberShimmerBrush()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = if (alignCenter) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(PortfolioColors.PrimaryContainer.copy(alpha = 0.5f))
                .border(BorderStroke(1.dp, shimmerBrush), RoundedCornerShape(20.dp))
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            Text(
                text = tag.uppercase(),
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.OnPrimaryContainer,
                letterSpacing = 1.2.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            color = PortfolioColors.OnSurface
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = subtitle,
            fontSize = 14.sp,
            color = PortfolioColors.OnSurfaceVariant,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun StatCard(
    stat: MetricStat,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val animatedBorderColor by animateColorAsState(
        targetValue = if (isHovered) PortfolioColors.Secondary else PortfolioColors.OutlineVariant,
        animationSpec = tween(300)
    )

    val animatedBgColor by animateColorAsState(
        targetValue = if (isHovered) PortfolioColors.SurfaceContainerHigh else PortfolioColors.SurfaceContainer,
        animationSpec = tween(300)
    )

    Box(
        modifier = modifier
            .interactiveHoverScale(targetScale = 1.03f)
            .clip(RoundedCornerShape(20.dp))
            .background(animatedBgColor)
            .border(1.dp, animatedBorderColor, RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        Column {
            Text(
                text = stat.value,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = PortfolioColors.Secondary,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stat.label,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = PortfolioColors.OnSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stat.description,
                fontSize = 12.sp,
                color = PortfolioColors.OnSurfaceVariant,
                lineHeight = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(PortfolioColors.Primary.copy(alpha = 0.15f))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "✦ ${stat.highlight}",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.Primary
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExperienceCard(
    experience: ExperienceItem,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(true) }
    val rotateChevron by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(300)
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val borderColor by animateColorAsState(
        targetValue = if (isHovered) PortfolioColors.Primary else PortfolioColors.OutlineVariant,
        animationSpec = tween(300)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .padding(22.dp)
    ) {
        Column {
            // Header Row: Role, Company & Expand Toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = experience.role,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.OnSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${experience.company} • ${experience.location}",
                        fontSize = 14.sp,
                        color = PortfolioColors.Primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(PortfolioColors.SurfaceContainerHigh)
                            .border(0.5.dp, PortfolioColors.Outline, RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = experience.period,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = PortfolioColors.Secondary
                        )
                    }

                    Text(
                        text = "▼",
                        fontSize = 12.sp,
                        color = PortfolioColors.OnSurfaceVariant,
                        modifier = Modifier.rotate(rotateChevron)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = experience.description,
                fontSize = 13.sp,
                color = PortfolioColors.OnSurfaceVariant,
                lineHeight = 20.sp
            )

            // Metrics Badges
            if (experience.metrics.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    experience.metrics.forEach { metric ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(PortfolioColors.EmeraldSuccess.copy(alpha = 0.15f))
                                .border(0.5.dp, PortfolioColors.EmeraldSuccess.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "★ $metric",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = PortfolioColors.EmeraldSuccess
                            )
                        }
                    }
                }
            }

            // Animated Expandable Content
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Achievements Bullet List
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        experience.achievements.forEach { achievement ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Text(
                                    text = "▹",
                                    color = PortfolioColors.Primary,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = achievement,
                                    fontSize = 13.sp,
                                    color = PortfolioColors.OnSurface,
                                    lineHeight = 20.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // Tech Stack Flow Row
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        experience.technologies.forEach { tech ->
                            TechChip(text = tech)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TechChip(
    text: String,
    modifier: Modifier = Modifier,
    highlight: Boolean = false
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (highlight) PortfolioColors.Primary.copy(alpha = 0.2f) else PortfolioColors.SurfaceContainerHigh)
            .border(
                0.5.dp,
                if (highlight) PortfolioColors.Primary else PortfolioColors.OutlineVariant,
                RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Monospace,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (highlight) PortfolioColors.OnPrimaryContainer else PortfolioColors.OnSurfaceVariant
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
        modifier = modifier
            .fillMaxWidth()
            .interactiveHoverScale(targetScale = 1.025f)
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .clickable { onViewDetail() },
        colors = CardDefaults.cardColors(containerColor = PortfolioColors.SurfaceContainer)
    ) {
        Column {
            // Project Image Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(Color(0xFF0C1322))
            ) {
                Image(
                    painter = painterResource(project.image),
                    contentDescription = project.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                // Category Pill Badge
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(PortfolioColors.Background.copy(alpha = 0.85f))
                        .border(0.5.dp, PortfolioColors.Primary, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = project.category,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.Primary
                    )
                }
            }

            // Project Info Content
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = project.title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.OnSurface
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = project.overview,
                    fontSize = 13.sp,
                    color = PortfolioColors.OnSurfaceVariant,
                    lineHeight = 19.sp,
                    maxLines = 3
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Tech tags (first 3)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    project.techStack.take(3).forEach { tech ->
                        TechChip(text = tech.substringBefore(":"))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Inspect Architecture ➔",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.Secondary,
                        modifier = Modifier.clickable { onViewDetail() }
                    )

                    if (project.playStoreUrl != null) {
                        Button(
                            onClick = { uriHandler.openUri(project.playStoreUrl) },
                            colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Play Store", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    } else if (project.githubUrl != null) {
                        OutlinedButton(
                            onClick = { uriHandler.openUri(project.githubUrl) },
                            border = BorderStroke(1.dp, PortfolioColors.Primary),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("GitHub", fontSize = 11.sp, color = PortfolioColors.Primary, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectDetailDialog(
    project: Project,
    onDismiss: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .border(1.dp, PortfolioColors.Primary, RoundedCornerShape(24.dp)),
            color = PortfolioColors.Surface
        ) {
            Column(
                modifier = Modifier.padding(26.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = project.title,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black,
                            color = PortfolioColors.OnSurface
                        )
                        Text(
                            text = project.category,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            color = PortfolioColors.Primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = "✕",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.OnSurfaceVariant,
                        modifier = Modifier
                            .clip(CircleShape)
                            .clickable { onDismiss() }
                            .padding(6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = PortfolioColors.OutlineVariant)
                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = project.overview,
                    fontSize = 14.sp,
                    color = PortfolioColors.OnSurfaceVariant,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Tech Stack
                Text(
                    text = "TECHNICAL ARCHITECTURE & STACK",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.Secondary,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    project.techStack.forEach { tech ->
                        Text(
                            text = "• $tech",
                            fontSize = 13.sp,
                            color = PortfolioColors.OnSurface,
                            lineHeight = 19.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Key Impact & Results
                Text(
                    text = "MEASURED IMPACT & STABILITY",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.EmeraldSuccess,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    project.impact.forEach { item ->
                        Text(
                            text = "★ $item",
                            fontSize = 13.sp,
                            color = PortfolioColors.OnSurface,
                            lineHeight = 19.sp
                        )
                    }
                }

                if (project.nextPlan.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "ROADMAP & NEXT MILESTONES",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.AmberAccent,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    project.nextPlan.forEach { plan ->
                        Text(
                            text = "→ $plan",
                            fontSize = 13.sp,
                            color = PortfolioColors.OnSurfaceVariant,
                            lineHeight = 19.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Footer CTA Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (project.playStoreUrl != null) {
                        Button(
                            onClick = { uriHandler.openUri(project.playStoreUrl) },
                            colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.Primary),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Play Store", fontWeight = FontWeight.Bold)
                        }
                    }
                    if (project.githubUrl != null) {
                        OutlinedButton(
                            onClick = { uriHandler.openUri(project.githubUrl) },
                            border = BorderStroke(1.dp, PortfolioColors.Primary),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("GitHub", color = PortfolioColors.Primary, fontWeight = FontWeight.Bold)
                        }
                    }
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(containerColor = PortfolioColors.SurfaceContainerHigh),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Close", color = PortfolioColors.OnSurface)
                    }
                }
            }
        }
    }
}
