package com.uziro.portfolio.ui.section

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.TimeZone.Companion.currentSystemDefault
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun FooterSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(6.dp))
        val currentYear = Clock.System.now().toLocalDateTime(currentSystemDefault()).year

        // ---- COPYRIGHT ----
        Text(
            "© $currentYear Iqbal Fauzi. Built with Compose Multiplatform.",
            color = Color.DarkGray,
            fontSize = 14.sp
        )

    }
}
