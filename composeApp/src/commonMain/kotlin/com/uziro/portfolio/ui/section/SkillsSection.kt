package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.CloudQueue
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.SkillCategory
import com.uziro.portfolio.data.repository.skillCategories
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.component.TonalTag

@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp)
        ) {
            SectionHeader(
                eyebrow = "Technical Arsenal",
                title = "Skills & Technology Matrix",
                subtitle = "Core Android Jetpack, Kotlin Multiplatform, Cloud & IoT protocols, automated testing, and technical leadership practices."
            )

            if (!layoutInfo.isCompact) {
                val chunks = skillCategories.chunked(2)
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    chunks.forEach { rowCategories ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            rowCategories.forEach { category ->
                                SkillCategoryCard(
                                    category = category,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            if (rowCategories.size == 1) {
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
                    skillCategories.forEach { category ->
                        SkillCategoryCard(
                            category = category,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillCategoryCard(
    category: SkillCategory,
    modifier: Modifier = Modifier
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = skillCategoryIcon(category.iconKey),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = category.highlight,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                category.skills.forEach { skill ->
                    val isCore = skill.contains("Kotlin", ignoreCase = true) ||
                        skill.contains("Compose", ignoreCase = true) ||
                        skill.contains("KMP", ignoreCase = true) ||
                        skill.contains("AI Harness", ignoreCase = true) ||
                        skill.contains("Remote Config", ignoreCase = true)
                    TonalTag(
                        text = skill,
                        emphasized = isCore
                    )
                }
            }
        }
    }
}

private fun skillCategoryIcon(iconKey: String): ImageVector = when (iconKey) {
    "mobile" -> Icons.Rounded.PhoneAndroid
    "cloud" -> Icons.Rounded.CloudQueue
    "testing" -> Icons.Rounded.VerifiedUser
    "optimization" -> Icons.Rounded.Tune
    "tools" -> Icons.Rounded.Build
    "leadership" -> Icons.Rounded.Groups
    else -> Icons.Rounded.Code
}
