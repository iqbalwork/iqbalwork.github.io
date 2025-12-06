package com.uziro.portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uziro.portfolio.section.HeaderSection
import com.uziro.portfolio.section.ProfileSection

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HeaderSection(modifier = Modifier.fillMaxWidth())
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)) {
            item {
                ProfileSection()
            }
        }
    }

}
