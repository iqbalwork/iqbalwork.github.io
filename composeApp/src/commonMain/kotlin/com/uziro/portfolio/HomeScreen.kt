package com.uziro.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = {}) {
                    Text(text = "Home")
                }
                Spacer(Modifier.width(8.dp))
                TextButton(onClick = {}) {
                    Text(text = "Services")
                }
                Spacer(Modifier.width(8.dp))
                TextButton(onClick = {}) {
                    Text(text = "About")
                }
                Spacer(Modifier.width(8.dp))
                TextButton(onClick = {}) {
                    Text(text = "Portfolio")
                }
                Spacer(Modifier.width(8.dp))
                TextButton(onClick = {}) {
                    Text(text = "Process")
                }
                Spacer(Modifier.width(8.dp))
                TextButton(onClick = {}) {
                    Text(text = "Contact")
                }
            }
        }
    ) {

    }

}
