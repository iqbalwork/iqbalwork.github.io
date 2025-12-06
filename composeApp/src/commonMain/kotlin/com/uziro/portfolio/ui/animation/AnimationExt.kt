package com.uziro.portfolio.ui.animation

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun rememberItemVisible(
    key: Any,
    listState: LazyListState
): Boolean {
    var isVisible by remember(key) { mutableStateOf(false) }

    LaunchedEffect(listState, key) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.any { it.key == key }
        }
            .distinctUntilChanged()
            .collect { currentlyVisible ->
                if (currentlyVisible) {
                    // animate once
                    isVisible = true
                }
            }
    }

    return isVisible
}

