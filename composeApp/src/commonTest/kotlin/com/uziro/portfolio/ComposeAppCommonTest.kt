package com.uziro.portfolio

import com.uziro.portfolio.data.repository.additionalProfileInfo
import com.uziro.portfolio.data.repository.educationInfo
import com.uziro.portfolio.data.repository.experienceList
import com.uziro.portfolio.data.repository.keyStats
import com.uziro.portfolio.data.repository.profileInfo
import com.uziro.portfolio.data.repository.projectList
import com.uziro.portfolio.data.repository.skillCategories
import com.uziro.portfolio.data.repository.socialMediaList
import com.uziro.portfolio.ui.theme.MaterialYouPalette
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ComposeAppCommonTest {

    @Test
    fun profileAndCvLinksAreConfigured() {
        assertEquals("Iqbal Fauzi", profileInfo.name)
        assertEquals("work.iqbalfauzi@gmail.com", profileInfo.email)
        assertTrue(profileInfo.cvUrl.contains("12_bC8Va-h_Gi1Z5pC3Ig1n4k2fEdiNWQyd5HOKFSigs"))
        assertEquals(4, keyStats.size)
        assertEquals("Universitas Siliwangi – Indonesia", educationInfo.institution)
        assertEquals(3, additionalProfileInfo.playStoreLinks.size)
        assertEquals(7, socialMediaList.size)
    }

    @Test
    fun boboboxExperienceReflectsLatestCvUpdates() {
        val bobobox = experienceList.first()
        assertEquals("PT Bobobox Mitra Indonesia", bobobox.company)
        assertEquals("Senior Android Engineer", bobobox.role)
        assertEquals(2, bobobox.phases.size)

        val currentAchievements = bobobox.phases.first().achievements.joinToString("\n")
        assertTrue(currentAchievements.contains("Kotlin Multiplatform"))
        assertTrue(currentAchievements.contains("Remote Config"))
        assertTrue(currentAchievements.contains("BPad"))
        assertTrue(currentAchievements.contains("AI Harness"))
    }

    @Test
    fun skillsAreDeduplicatedAndCoverAllSixCvCategories() {
        assertEquals(6, skillCategories.size)
        skillCategories.forEach { category ->
            assertEquals(category.skills.distinct().size, category.skills.size)
        }
        assertEquals(6, projectList.size)
        assertEquals("Robithoh", projectList.first().title)
        assertEquals("https://robithoh.vercel.app/", projectList.first().url)
        assertEquals(5, MaterialYouPalette.entries.size)
    }
}
