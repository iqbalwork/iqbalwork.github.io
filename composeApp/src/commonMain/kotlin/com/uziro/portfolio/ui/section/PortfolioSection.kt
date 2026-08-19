package com.uziro.portfolio.ui.section

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.repository.projectList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.component.ProjectCard
import com.uziro.portfolio.ui.component.ProjectDetailDialog
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.theme.PortfolioColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PortfolioSection(
    modifier: Modifier = Modifier,
    onProjectClick: (Project) -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("All") }
    var inspectingProject by remember { mutableStateOf<Project?>(null) }

    val categories = listOf("All", "Hospitality & IoT", "Education & Utility", "Kotlin Multiplatform (KMP)", "Healthcare & Emergency")

    val filteredProjects = remember(selectedCategory) {
        if (selectedCategory == "All") projectList else projectList.filter { it.category == selectedCategory }
    }

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.Background)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 44.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    tag = "Featured Work",
                    title = "Key Projects & Case Studies",
                    subtitle = "Production-grade applications delivering high concurrency, low latency, and rock-solid 99.9% crash-free rates."
                )

                // Category Filter Pills with Material You styling & Hover Animation
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    categories.forEach { category ->
                        val isSelected = selectedCategory == category
                        val bgColor by animateColorAsState(
                            targetValue = if (isSelected) PortfolioColors.PrimaryContainer else PortfolioColors.SurfaceContainer,
                            animationSpec = tween(300)
                        )
                        val textColor by animateColorAsState(
                            targetValue = if (isSelected) PortfolioColors.OnPrimaryContainer else PortfolioColors.OnSurfaceVariant,
                            animationSpec = tween(300)
                        )
                        val borderColor by animateColorAsState(
                            targetValue = if (isSelected) PortfolioColors.Primary else PortfolioColors.OutlineVariant,
                            animationSpec = tween(300)
                        )

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(bgColor)
                                .border(1.dp, borderColor, RoundedCornerShape(12.dp))
                                .interactiveHoverScale(targetScale = 1.05f)
                                .clickable { selectedCategory = category }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = category,
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = textColor
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Adaptive Grid for Projects
                if (layoutInfo.isExpanded) {
                    // 3-Column Desktop Grid
                    val chunks = filteredProjects.chunked(3)
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        chunks.forEach { rowProjects ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                rowProjects.forEach { project ->
                                    ProjectCard(
                                        project = project,
                                        onViewDetail = {
                                            inspectingProject = project
                                            onProjectClick(project)
                                        },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                for (i in 0 until (3 - rowProjects.size)) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else if (layoutInfo.isMedium) {
                    // 2-Column Tablet Grid
                    val chunks = filteredProjects.chunked(2)
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        chunks.forEach { rowProjects ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                rowProjects.forEach { project ->
                                    ProjectCard(
                                        project = project,
                                        onViewDetail = {
                                            inspectingProject = project
                                            onProjectClick(project)
                                        },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                if (rowProjects.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else {
                    // 1-Column Mobile
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        filteredProjects.forEach { project ->
                            ProjectCard(
                                project = project,
                                onViewDetail = {
                                    inspectingProject = project
                                    onProjectClick(project)
                                },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }

            // Project Detail Modal Dialog
            if (inspectingProject != null) {
                ProjectDetailDialog(
                    project = inspectingProject!!,
                    onDismiss = { inspectingProject = null }
                )
            }
        }
    }
}
