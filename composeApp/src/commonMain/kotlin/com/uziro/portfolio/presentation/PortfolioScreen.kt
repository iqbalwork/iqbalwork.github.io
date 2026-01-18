package com.uziro.portfolio.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.section.HeaderSection
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.bobobox_port

/**
 * iqbalfauzi
 * Email: work.iqbalfauzi@gmail.com
 * Github: https://github.com/iqbalwork
 */
@Composable
fun ProjectDetailScreen(
    project: Project,
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            HeaderSection()
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF9F9F9))
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 100.dp, vertical = 60.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            // Back Button
            Row(
                modifier = Modifier
                    .clickable { onBack() }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "← Back to Portfolio",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6B63FF)
                    )
                )
            }

            // Title & Action
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.weight(1f)
                )

                project.url?.let { url ->
                    Button(
                        onClick = { uriHandler.openUri(url) },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6B63FF)
                        ),
                        modifier = Modifier.padding(start = 24.dp)
                    ) {
                        Text(
                            text = if (url.contains("github")) "View GitHub" else "View on Store",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Image(
                painter = painterResource(project.image),
                contentDescription = project.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(800.dp)
                    .height(600.dp)
                    .clip(RoundedCornerShape(14.dp))
            )

            // Overview
            SectionItem(title = "Overview", content = project.overview)

            // Tech Stack
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = "Tech Stack",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    project.techStack.forEach { tech ->
                        Text(
                            text = tech,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                }
            }

            // Impact & Result
            BulletSection(title = "Impact & Result", items = project.impact)

            // Next Plan
            if (project.nextPlan.isNotEmpty()) {
                BulletSection(title = "Next Plan", items = project.nextPlan)
            }
        }
    }
}

@Composable
fun SectionItem(title: String, content: String) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 28.sp,
                color = Color.DarkGray
            )
        )
    }
}

@Composable
fun BulletSection(title: String, items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        items.forEach { item ->
            Text(
                text = "• $item",
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 28.sp,
                    color = Color.DarkGray
                )
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 1080, widthDp = 1920)
@Composable
fun PreviewProjectDetailScreen() {
    val sampleProject = Project(
        title = "Bobobox",
        image = Res.drawable.bobobox_port,
        overview = "Bobobox is an Indonesian tech-integrated hospitality brand that redefines budget accommodation through its innovative capsule hotels and glamping experiences. Founded in 2017, Bobobox aims to provide affordable, comfortable, and high-tech stays for modern travelers.",
        techStack = listOf(
            "Kotlin",
            "Jetpack Compose",
            "Clean Architecture",
            "Dagger Hilt",
            "Retrofit"
        ),
        impact = listOf(
            "Increased user engagement by 25% with new UI/UX",
            "Reduced app crash rate to less than 0.1%",
            "Successfully integrated smart room control features"
        ),
        nextPlan = listOf(
            "Expand to international markets",
            "Implement AI-driven personalized travel recommendations"
        ),
        url = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox"
    )
    MaterialTheme {
        ProjectDetailScreen(project = sampleProject)
    }
}
