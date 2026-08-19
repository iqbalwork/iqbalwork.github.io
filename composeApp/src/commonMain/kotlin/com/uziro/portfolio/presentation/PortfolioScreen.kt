package com.uziro.portfolio.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.adaptive.AdaptiveBox
import com.uziro.portfolio.ui.component.TechChip
import com.uziro.portfolio.ui.section.HeaderSection
import com.uziro.portfolio.ui.theme.PortfolioColors
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectDetailScreen(
    project: Project,
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    AdaptiveBox(modifier = modifier.fillMaxSize()) { layoutInfo ->
        Scaffold(
            containerColor = PortfolioColors.BgVoid,
            topBar = {
                HeaderSection(onNavigateToIndex = { onBack() })
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PortfolioColors.BgVoid)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = layoutInfo.horizontalPadding, vertical = 32.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Back Button
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .clickable { onBack() }
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "← Back to Portfolio",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = PortfolioColors.KotlinPurple
                    )
                }

                // Title & Action
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = project.title,
                            fontSize = if (layoutInfo.isCompact) 26.sp else 34.sp,
                            fontWeight = FontWeight.Black,
                            color = PortfolioColors.TextPrimary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = project.category,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            color = PortfolioColors.KotlinPurple,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    project.url?.let { url ->
                        Button(
                            onClick = { uriHandler.openUri(url) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PortfolioColors.KotlinPurple
                            )
                        ) {
                            Text(
                                text = if (url.contains("github")) "View on GitHub" else "Open in Play Store",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Banner image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(if (layoutInfo.isCompact) 220.dp else 360.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(PortfolioColors.BgCard)
                        .border(1.dp, PortfolioColors.BorderSubtle, RoundedCornerShape(14.dp))
                ) {
                    Image(
                        painter = painterResource(project.image),
                        contentDescription = project.title,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Overview Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(PortfolioColors.BgCard)
                        .border(1.dp, PortfolioColors.BorderSubtle, RoundedCornerShape(12.dp))
                        .padding(20.dp)
                ) {
                    Column {
                        Text(
                            text = "PROJECT OVERVIEW",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = PortfolioColors.JetpackTeal,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = project.overview,
                            fontSize = 14.sp,
                            color = PortfolioColors.TextSecondary,
                            lineHeight = 22.sp
                        )
                    }
                }

                // Tech Stack Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(PortfolioColors.BgCard)
                        .border(1.dp, PortfolioColors.BorderSubtle, RoundedCornerShape(12.dp))
                        .padding(20.dp)
                ) {
                    Column {
                        Text(
                            text = "ARCHITECTURE & TECHNICAL STACK",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = PortfolioColors.KotlinPurple,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            project.techStack.forEach { tech ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text("▹", color = PortfolioColors.KotlinPurple, fontWeight = FontWeight.Bold)
                                    Text(
                                        text = tech,
                                        fontSize = 13.sp,
                                        color = PortfolioColors.TextPrimary
                                    )
                                }
                            }
                        }
                    }
                }

                // Impact & Result Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(PortfolioColors.BgCard)
                        .border(1.dp, PortfolioColors.BorderSubtle, RoundedCornerShape(12.dp))
                        .padding(20.dp)
                ) {
                    Column {
                        Text(
                            text = "MEASURED RESULTS & METRICS",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = PortfolioColors.EmeraldSuccess,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            project.impact.forEach { item ->
                                Row(
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text("★", color = PortfolioColors.EmeraldSuccess, fontWeight = FontWeight.Bold)
                                    Text(
                                        text = item,
                                        fontSize = 13.sp,
                                        color = PortfolioColors.TextPrimary,
                                        lineHeight = 20.sp
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
