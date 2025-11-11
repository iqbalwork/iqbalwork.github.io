package com.uziro.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderMenu(title = "Home") {}
        Spacer(Modifier.width(8.dp))
        HeaderMenu(title = "Services") {}
        Spacer(Modifier.width(8.dp))
        HeaderMenu(title = "About") {}
        Spacer(Modifier.width(8.dp))
        HeaderMenu(title = "Portfolio") {}
        Spacer(Modifier.width(8.dp))
        HeaderMenu(title = "Process") {}
        Spacer(Modifier.width(8.dp))
        HeaderMenu(title = "Contact") {}
    }
}

@Composable
fun HeaderMenu(modifier: Modifier = Modifier, title: String, onClick: (String) -> Unit) {
    TextButton(onClick = {
        onClick(title)
    }, modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black)
        )
    }
}
