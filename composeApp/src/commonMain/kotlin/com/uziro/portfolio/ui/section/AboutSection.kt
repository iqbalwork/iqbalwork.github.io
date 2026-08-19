package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.repository.experienceList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.BoboboxIotPodDemo
import com.uziro.portfolio.ui.component.ExperienceCard
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.component.SpatialVerseHighlightDemo
import com.uziro.portfolio.ui.theme.PortfolioColors

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.BgVoid)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 40.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Section 1: Professional Experience Timeline
                SectionHeader(
                    tag = "Career Trajectory",
                    title = "Professional Experience",
                    subtitle = "7+ years scaling mobile architectures, leading multi-module migrations, and engineering high-impact features."
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    experienceList.forEach { exp ->
                        ExperienceCard(experience = exp)
                    }
                }

                Spacer(modifier = Modifier.height(48.dp))

                // Section 2: Interactive Engineering Showcases
                SectionHeader(
                    tag = "Interactive Demos",
                    title = "Engineering in Action",
                    subtitle = "Test-drive the actual core systems engineered across production apps: Bobobox IoT MQTT Pod controller and Al Qosbah Spatial Verse Highlighting."
                )

                if (layoutInfo.isExpanded) {
                    // Side-by-side on desktop
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        BoboboxIotPodDemo(modifier = Modifier.weight(1f))
                        SpatialVerseHighlightDemo(modifier = Modifier.weight(1f))
                    }
                } else {
                    // Stacked on tablet & mobile
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        BoboboxIotPodDemo(modifier = Modifier.fillMaxWidth())
                        SpatialVerseHighlightDemo(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}
