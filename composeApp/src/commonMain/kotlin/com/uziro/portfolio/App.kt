package com.uziro.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.presentation.HomeScreen
import com.uziro.portfolio.presentation.ProjectDetailScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(widthDp = 1920, heightDp = 1080)
fun App() {
    MaterialTheme {
        var selectedProject by remember { mutableStateOf<Project?>(null) }
        
        if (selectedProject == null) {
            HomeScreen(onProjectClick = { project ->
                selectedProject = project
            })
        } else {
            ProjectDetailScreen(
                project = selectedProject!!,
                onBack = { selectedProject = null }
            )
        }
    }
}
