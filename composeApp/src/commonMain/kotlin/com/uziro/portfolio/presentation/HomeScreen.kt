package com.uziro.portfolio.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.Work
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.section.AboutSection
import com.uziro.portfolio.ui.section.ContactSection
import com.uziro.portfolio.ui.section.HomeSection
import com.uziro.portfolio.ui.section.PortfolioSection
import com.uziro.portfolio.ui.section.SkillsSection
import com.uziro.portfolio.ui.theme.MaterialYouPalette
import kotlinx.coroutines.launch

private data class NavDestination(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val index: Int
)

private val portfolioDestinations = listOf(
    NavDestination("Home", Icons.Rounded.Home, Icons.Outlined.Home, 0),
    NavDestination("Experience", Icons.Rounded.Work, Icons.Outlined.WorkOutline, 1),
    NavDestination("Projects", Icons.Rounded.Apps, Icons.Outlined.Apps, 2),
    NavDestination("Skills", Icons.Rounded.Code, Icons.Outlined.Code, 3),
    NavDestination("Contact", Icons.Rounded.Mail, Icons.Outlined.Mail, 4)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    selectedPalette: MaterialYouPalette,
    onToggleDarkTheme: () -> Unit,
    onOpenStyleSheet: () -> Unit,
    onProjectClick: (Project) -> Unit = {}
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val activeIndexState = rememberActiveSectionIndex(lazyListState)

    val navigateTo: (Int) -> Unit = { targetIndex ->
        coroutineScope.launch {
            lazyListState.animateScrollToItem(targetIndex)
        }
    }

    AdaptiveBox(modifier = Modifier.fillMaxSize()) { layoutInfo ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            if (!layoutInfo.isCompact) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                    header = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
                        ) {
                            FloatingActionButton(
                                onClick = { uriHandler.openUri(profileInfo.cvUrl) },
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Description,
                                    contentDescription = "Open CV"
                                )
                            }
                        }
                    }
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    portfolioDestinations.forEach { dest ->
                        val selected = activeIndexState.value == dest.index
                        NavigationRailItem(
                            selected = selected,
                            onClick = { navigateTo(dest.index) },
                            icon = {
                                Icon(
                                    imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                    contentDescription = dest.label
                                )
                            },
                            label = { Text(dest.label) }
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }

                VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            }

            Scaffold(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                containerColor = MaterialTheme.colorScheme.surface,
                topBar = {
                    PortfolioTopAppBar(
                        isCompact = layoutInfo.isCompact,
                        isDarkTheme = isDarkTheme,
                        selectedPalette = selectedPalette,
                        scrollBehavior = scrollBehavior,
                        onBrandClick = { navigateTo(0) },
                        onToggleDarkTheme = onToggleDarkTheme,
                        onOpenStyleSheet = onOpenStyleSheet
                    )
                },
                bottomBar = {
                    if (layoutInfo.isCompact) {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                        ) {
                            portfolioDestinations.forEach { dest ->
                                val selected = activeIndexState.value == dest.index
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navigateTo(dest.index) },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                            contentDescription = dest.label
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = dest.label,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    item(key = "home") {
                        BoundedSectionContainer {
                            HomeSection()
                        }
                    }
                    item(key = "experience") {
                        BoundedSectionContainer {
                            SectionDivider()
                            AboutSection()
                        }
                    }
                    item(key = "projects") {
                        BoundedSectionContainer {
                            SectionDivider()
                            PortfolioSection(onProjectClick = onProjectClick)
                        }
                    }
                    item(key = "skills") {
                        BoundedSectionContainer {
                            SectionDivider()
                            SkillsSection()
                        }
                    }
                    item(key = "contact") {
                        BoundedSectionContainer {
                            SectionDivider()
                            ContactSection()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PortfolioTopAppBar(
    isCompact: Boolean,
    isDarkTheme: Boolean,
    selectedPalette: MaterialYouPalette,
    scrollBehavior: androidx.compose.material3.TopAppBarScrollBehavior,
    onBrandClick: () -> Unit,
    onToggleDarkTheme: () -> Unit,
    onOpenStyleSheet: () -> Unit
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    onClick = onBrandClick,
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "IF",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column {
                    Text(
                        text = profileInfo.name,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Android · Kotlin Multiplatform",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        },
        actions = {
            if (!isCompact) {
                Surface(
                    onClick = onOpenStyleSheet,
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(end = 6.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Palette,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = selectedPalette.displayName,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            } else {
                FilledTonalIconButton(onClick = onOpenStyleSheet) {
                    Icon(
                        imageVector = Icons.Rounded.Palette,
                        contentDescription = "Wallpaper & style"
                    )
                }
            }

            IconButton(
                onClick = onToggleDarkTheme,
                modifier = Modifier.padding(end = 4.dp)
            ) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Rounded.LightMode else Icons.Rounded.DarkMode,
                    contentDescription = if (isDarkTheme) "Switch to light theme" else "Switch to dark theme"
                )
            }
        }
    )
}

@Composable
private fun BoundedSectionContainer(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.widthIn(max = 1120.dp).fillMaxWidth()) {
            content()
        }
    }
}

@Composable
private fun SectionDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 24.dp),
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.55f)
    )
}

@Composable
private fun rememberActiveSectionIndex(listState: LazyListState): State<Int> {
    return remember(listState) {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val visibleItems = layoutInfo.visibleItemsInfo
            if (visibleItems.isEmpty()) {
                0
            } else {
                val lastItem = visibleItems.lastOrNull()
                val reachedBottom = lastItem != null &&
                    lastItem.index == layoutInfo.totalItemsCount - 1 &&
                    (lastItem.offset + lastItem.size) <= layoutInfo.viewportEndOffset + 24

                if (reachedBottom) {
                    lastItem.index
                } else {
                    val viewportCenter = layoutInfo.viewportStartOffset +
                        (layoutInfo.viewportEndOffset - layoutInfo.viewportStartOffset) / 3
                    visibleItems.firstOrNull { item ->
                        item.offset <= viewportCenter && (item.offset + item.size) > viewportCenter
                    }?.index ?: listState.firstVisibleItemIndex
                }
            }
        }
    }
}
