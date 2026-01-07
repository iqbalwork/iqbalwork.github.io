package com.uziro.portfolio.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.uziro.portfolio.ui.section.AboutSection
import com.uziro.portfolio.ui.section.ContactSection
import com.uziro.portfolio.ui.section.FooterSection
import com.uziro.portfolio.ui.section.HeaderSection
import com.uziro.portfolio.ui.section.HomeSection
import com.uziro.portfolio.ui.section.PortfolioCard
import com.uziro.portfolio.ui.section.PortfolioSection
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HeaderSection(modifier = Modifier.fillMaxWidth()) { index ->
                coroutineScope.launch {
                    lazyListState.animateScrollToItem(index)
                }
            }
        }
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            item {
                HomeSection(modifier = Modifier.fillParentMaxHeight())
            }
            item {
                AboutSection(modifier = Modifier)
            }
            item {
                PortfolioSection(modifier = Modifier)
            }
            item {
                ContactSection(modifier = Modifier)
            }
            item {
                FooterSection(modifier = Modifier)
            }
        }
    }

}
