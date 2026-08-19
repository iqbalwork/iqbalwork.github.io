package com.uziro.portfolio.data

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class ProfileInfo(
    val name: String,
    val title: String,
    val location: String,
    val email: String,
    val phone: String,
    val summary: String,
    val whatsappUrl: String,
    val cvUrl: String,
    val linkedinUrl: String,
    val githubUrl: String
)

@Serializable
data class MetricStat(
    val value: String,
    val label: String,
    val description: String,
    val highlight: String
)

@Serializable
data class ExperienceItem(
    val company: String,
    val role: String,
    val period: String,
    val location: String,
    val type: String = "Full Time",
    val description: String,
    val achievements: List<String>,
    val technologies: List<String>,
    val metrics: List<String> = emptyList()
)

@Serializable
data class SkillCategory(
    val name: String,
    val iconName: String,
    val skills: List<String>,
    val highlight: String
)

@Serializable
data class EducationItem(
    val degree: String,
    val institution: String,
    val location: String,
    val period: String,
    val description: String
)

@Serializable
data class Project(
    val title: String,
    val category: String = "Mobile",
    val image: DrawableResource,
    val overview: String,
    val techStack: List<String>,
    val impact: List<String>,
    val nextPlan: List<String> = emptyList(),
    val playStoreUrl: String? = null,
    val githubUrl: String? = null,
    val url: String? = null
)
