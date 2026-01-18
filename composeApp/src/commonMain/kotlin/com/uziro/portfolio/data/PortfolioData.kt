package com.uziro.portfolio.data

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class PortfolioData(
    val projects: List<Project>
)

@Serializable
data class Project(
    val title: String,
    val image: DrawableResource,
    val overview: String,
    val techStack: List<String>,
    val impact: List<String>,
    val nextPlan: List<String> = emptyList(),
    val url: String? = null
)
