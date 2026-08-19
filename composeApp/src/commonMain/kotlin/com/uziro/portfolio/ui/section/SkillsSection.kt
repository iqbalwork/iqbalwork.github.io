package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.SkillCategory
import com.uziro.portfolio.data.repository.skillCategories
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.animation.interactiveHoverScale
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.component.TechChip
import com.uziro.portfolio.ui.theme.PortfolioColors

@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.Background)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 44.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    tag = "Technical Arsenal",
                    title = "Skills & Technology Matrix",
                    subtitle = "Comprehensive mastery of the Android Jetpack ecosystem, Kotlin Multiplatform, Cloud/IoT protocols, and quality standards."
                )

                if (layoutInfo.isExpanded) {
                    // 2-Column Grid on desktop
                    val chunks = skillCategories.chunked(2)
                    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        chunks.forEach { rowCategories ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(18.dp)
                            ) {
                                rowCategories.forEach { category ->
                                    SkillCategoryCard(category = category, modifier = Modifier.weight(1f))
                                }
                                if (rowCategories.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else {
                    // 1-Column on tablet & mobile
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        skillCategories.forEach { category ->
                            SkillCategoryCard(category = category, modifier = Modifier.fillMaxWidth())
                        }
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
    Box(
        modifier = modifier
            .interactiveHoverScale(targetScale = 1.025f)
            .clip(RoundedCornerShape(20.dp))
            .background(PortfolioColors.SurfaceContainer)
            .border(1.dp, PortfolioColors.OutlineVariant, RoundedCornerShape(20.dp))
            .padding(22.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = category.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.OnSurface
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "★ ${category.highlight}",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                color = PortfolioColors.Primary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                category.skills.forEach { skill ->
                    TechChip(text = skill, highlight = skill.contains("Kotlin") || skill.contains("Compose"))
                }
            }
        }
    }
}
