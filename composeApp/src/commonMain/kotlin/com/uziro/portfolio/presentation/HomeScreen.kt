package com.uziro.portfolio.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.ui.section.AboutSection
import com.uziro.portfolio.ui.section.ContactSection
import com.uziro.portfolio.ui.section.HeaderSection
import com.uziro.portfolio.ui.section.HomeSection
import com.uziro.portfolio.ui.section.PortfolioSection
import com.uziro.portfolio.ui.section.SkillsSection
import com.uziro.portfolio.ui.theme.PortfolioColors
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onProjectClick: (Project) -> Unit = {}
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = PortfolioColors.BgVoid,
        topBar = {
            HeaderSection(
                modifier = Modifier.fillMaxWidth(),
                onNavigateToIndex = { targetIndex ->
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(targetIndex)
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(PortfolioColors.BgVoid)
        ) {
            // Index 0: Home / Hero & Stats
            item {
                HomeSection()
            }

            // Index 1: Experience & Interactive Demos
            item {
                AboutSection()
            }

            // Index 2: Key Projects & Case Studies
            item {
                PortfolioSection(onProjectClick = onProjectClick)
            }

            // Index 3: Technical Skills Matrix
            item {
                SkillsSection()
            }

            // Index 4: Contact, Education & Footer
            item {
                ContactSection()
            }
        }
    }
}
