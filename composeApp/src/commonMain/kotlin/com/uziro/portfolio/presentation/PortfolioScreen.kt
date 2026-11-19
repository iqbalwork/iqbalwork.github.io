package com.uziro.portfolio.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.OpenInNew
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.theme.statusColors
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProjectDetailScreen(
    project: Project,
    isDarkTheme: Boolean,
    onToggleDarkTheme: () -> Unit,
    onOpenStyleSheet: () -> Unit,
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    AdaptiveBox(modifier = modifier.fillMaxSize()) { layoutInfo ->
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            containerColor = MaterialTheme.colorScheme.surface,
            topBar = {
                TopAppBar(
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    ),
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Back to portfolio"
                            )
                        }
                    },
                    title = {
                        Column {
                            Text(
                                text = project.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = project.category,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = onOpenStyleSheet) {
                            Icon(
                                imageVector = Icons.Rounded.Palette,
                                contentDescription = "Wallpaper & style"
                            )
                        }
                        IconButton(onClick = onToggleDarkTheme) {
                            Icon(
                                imageVector = if (isDarkTheme) Icons.Rounded.LightMode else Icons.Rounded.DarkMode,
                                contentDescription = if (isDarkTheme) "Switch to light theme" else "Switch to dark theme"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .widthIn(max = 920.dp)
                        .fillMaxWidth()
                        .padding(horizontal = layoutInfo.horizontalPadding, vertical = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Header & External Link Action
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ) {
                                Text(
                                    text = project.category,
                                    style = MaterialTheme.typography.labelMedium,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                                )
                            }
                            Text(
                                text = project.title,
                                style = if (layoutInfo.isCompact) {
                                    MaterialTheme.typography.headlineMedium
                                } else {
                                    MaterialTheme.typography.displaySmall
                                },
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            val websiteUrl = project.url?.takeIf {
                                it != project.playStoreUrl && it != project.githubUrl
                            }

                            project.playStoreUrl?.let { playUrl ->
                                ProjectActionButton(
                                    label = "Open in Play Store",
                                    icon = Icons.Rounded.Shop,
                                    isPrimary = true,
                                    onClick = { uriHandler.openUri(playUrl) }
                                )
                            }

                            project.githubUrl?.let { repoUrl ->
                                ProjectActionButton(
                                    label = if (project.playStoreUrl == null) "View on GitHub" else "GitHub",
                                    icon = Icons.Rounded.Code,
                                    isPrimary = project.playStoreUrl == null,
                                    onClick = { uriHandler.openUri(repoUrl) }
                                )
                            }

                            websiteUrl?.let { webUrl ->
                                ProjectActionButton(
                                    label = "Visit Website",
                                    icon = Icons.AutoMirrored.Rounded.OpenInNew,
                                    isPrimary = project.playStoreUrl == null && project.githubUrl == null,
                                    onClick = { uriHandler.openUri(webUrl) }
                                )
                            }
                        }
                    }

                    // Project Banner
                    val isLogoArtwork = project.image == Res.drawable.compose_multiplatform
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        color = MaterialTheme.colorScheme.surfaceContainerHigh,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (layoutInfo.isCompact) 200.dp else 300.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(project.image),
                                contentDescription = project.title,
                                contentScale = ContentScale.Fit,
                                modifier = if (isLogoArtwork) {
                                    Modifier.size(120.dp)
                                } else {
                                    Modifier
                                        .fillMaxSize()
                                        .padding(12.dp)
                                        .clip(MaterialTheme.shapes.large)
                                }
                            )
                        }
                    }

                    // Overview
                    DetailCard(title = "Project Overview") {
                        Text(
                            text = project.overview,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Architecture & Stack
                    DetailCard(title = "Architecture & Technical Stack") {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            project.techStack.forEach { tech ->
                                Row(
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.CheckCircle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier
                                            .padding(top = 2.dp)
                                            .size(18.dp)
                                    )
                                    Text(
                                        text = tech,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }

                    // Measured Impact
                    DetailCard(title = "Measured Results & Metrics") {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            project.impact.forEach { item ->
                                Row(
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Verified,
                                        contentDescription = null,
                                        tint = MaterialTheme.statusColors.success,
                                        modifier = Modifier
                                            .padding(top = 2.dp)
                                            .size(18.dp)
                                    )
                                    Text(
                                        text = item,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }

                    // Next Plan / Roadmap
                    if (project.nextPlan.isNotEmpty()) {
                        DetailCard(title = "Roadmap & Ongoing Initiatives") {
                            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                project.nextPlan.forEach { plan ->
                                    Row(
                                        verticalAlignment = Alignment.Top,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.tertiary,
                                            modifier = Modifier
                                                .padding(top = 2.dp)
                                                .size(18.dp)
                                        )
                                        Text(
                                            text = plan,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectActionButton(
    label: String,
    icon: ImageVector,
    isPrimary: Boolean,
    onClick: () -> Unit
) {
    if (isPrimary) {
        Button(
            onClick = onClick,
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(label)
        }
    } else {
        FilledTonalButton(
            onClick = onClick,
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(label)
        }
    }
}

@Composable
private fun DetailCard(
    title: String,
    content: @Composable () -> Unit
) {
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
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            content()
        }
    }
}
