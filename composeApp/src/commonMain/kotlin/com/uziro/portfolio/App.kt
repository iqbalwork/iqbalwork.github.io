package com.uziro.portfolio

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.presentation.HomeScreen
import com.uziro.portfolio.presentation.ProjectDetailScreen
import com.uziro.portfolio.ui.component.ThemeStyleSheet
import com.uziro.portfolio.ui.theme.MaterialYouPalette
import com.uziro.portfolio.ui.theme.PortfolioTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(widthDp = 1280, heightDp = 800)
fun App() {
    val systemDark = isSystemInDarkTheme()
    var isDarkTheme by remember(systemDark) { mutableStateOf(systemDark) }
    var selectedPalette by remember { mutableStateOf(MaterialYouPalette.ANDROID_SAGE) }
    var showStyleSheet by remember { mutableStateOf(false) }
    var selectedProject by remember { mutableStateOf<Project?>(null) }

    PortfolioTheme(
        darkTheme = isDarkTheme,
        palette = selectedPalette
    ) {
        val currentProject = selectedProject
        if (currentProject == null) {
            HomeScreen(
                isDarkTheme = isDarkTheme,
                selectedPalette = selectedPalette,
                onToggleDarkTheme = { isDarkTheme = !isDarkTheme },
                onOpenStyleSheet = { showStyleSheet = true },
                onProjectClick = { clicked -> selectedProject = clicked }
            )
        } else {
            ProjectDetailScreen(
                project = currentProject,
                isDarkTheme = isDarkTheme,
                onToggleDarkTheme = { isDarkTheme = !isDarkTheme },
                onOpenStyleSheet = { showStyleSheet = true },
                onBack = { selectedProject = null }
            )
        }

        if (showStyleSheet) {
            ThemeStyleSheet(
                isDarkTheme = isDarkTheme,
                selectedPalette = selectedPalette,
                onToggleDarkTheme = { isDarkTheme = it },
                onSelectPalette = { selectedPalette = it },
                onDismiss = { showStyleSheet = false }
            )
        }
    }
}
