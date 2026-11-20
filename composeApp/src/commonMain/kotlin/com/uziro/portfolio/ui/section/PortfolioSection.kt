package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.repository.projectList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.ProjectCard
import com.uziro.portfolio.ui.component.SectionHeader

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PortfolioSection(
    modifier: Modifier = Modifier,
    onProjectClick: (Project) -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = remember {
        listOf("All") + projectList.map { it.category }.distinct()
    }

    val filteredProjects = remember(selectedCategory) {
        if (selectedCategory == "All") projectList else projectList.filter { it.category == selectedCategory }
    }

    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp)
        ) {
            SectionHeader(
                eyebrow = "Featured Work",
                title = "Projects & Case Studies",
                subtitle = "Production applications engineered for high concurrency, cross-platform consistency, and 99.9% crash-free reliability."
            )

            // Semantic Material 3 FilterChips
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                categories.forEach { category ->
                    val isSelected = selectedCategory == category
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = category },
                        label = { Text(category) },
                        leadingIcon = if (isSelected) {
                            {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            val columns = layoutInfo.gridColumns
            if (columns > 1) {
                val chunks = filteredProjects.chunked(columns)
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    chunks.forEach { rowProjects ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            rowProjects.forEach { project ->
                                ProjectCard(
                                    project = project,
                                    onViewDetail = { onProjectClick(project) },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            for (i in 0 until (columns - rowProjects.size)) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    filteredProjects.forEach { project ->
                        ProjectCard(
                            project = project,
                            onViewDetail = { onProjectClick(project) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
