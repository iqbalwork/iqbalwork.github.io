package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.data.repository.experienceList
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.BoboboxIotPodDemo
import com.uziro.portfolio.ui.component.ExperienceCard
import com.uziro.portfolio.ui.component.SectionHeader
import com.uziro.portfolio.ui.component.SpatialVerseHighlightDemo

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    AdaptiveBox(modifier = modifier.fillMaxWidth()) { layoutInfo ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp)
        ) {
            SectionHeader(
                eyebrow = "Career Trajectory",
                title = "Professional Experience",
                subtitle = "7+ years scaling Android & Kotlin Multiplatform architectures, leading multi-module migrations, IoT hardware systems, and engineering standards."
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                experienceList.forEachIndexed { index, exp ->
                    ExperienceCard(
                        experience = exp,
                        initiallyExpanded = index <= 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            SectionHeader(
                eyebrow = "Interactive Lab",
                title = "Engineering in Action",
                subtitle = "Try interactive Compose simulations of core production systems: Bobobox IoT Smart Pod MQTT controls and Al Qosbah Spatial Verse Highlighting."
            )

            if (layoutInfo.isExpanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    BoboboxIotPodDemo(modifier = Modifier.weight(1f))
                    SpatialVerseHighlightDemo(modifier = Modifier.weight(1f))
                }
            } else {
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
