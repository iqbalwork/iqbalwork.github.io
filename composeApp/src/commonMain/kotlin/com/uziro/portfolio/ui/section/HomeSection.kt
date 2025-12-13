package com.uziro.portfolio.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uziro.portfolio.ui.component.TextLabelButton
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeSection(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()   // or .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp)
            .background(Color(0xFFF4ECF8)),
        contentAlignment = Alignment.Center
    ) {

        val uriHandler = LocalUriHandler.current

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,  // Center vertically
            modifier = Modifier.fillMaxWidth()
        ) {
            // Hello Badge
            TextLabelButton(
                value = "*HELLO!*",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
            )

            Spacer(Modifier.height(20.dp))

            // Title
            Text(
                "I'm Iqbal Fauzi",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            // Subtitle
            Text(
                "Android Engineer • Kotlin Multiplatform Enthusiast",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(Modifier.height(20.dp))

            Text(
                "I’m a Software Engineer based in Bandung, Indonesia. Currently adopting Kotlin Multiplatform to build wider platform.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(700.dp)
            )

            Spacer(Modifier.height(28.dp))

            // Buttons
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(onClick = {
                    uriHandler.openUri("https://wa.me/6287822882668")
                }) { Text("WhatsApp Me") }

                OutlinedButton(onClick = {
                    uriHandler.openUri("https://docs.google.com/document/d/12_bC8Va-h_Gi1Z5pC3Ig1n4k2fEdiNWQyd5HOKFSigs/edit?usp=sharing")
                }) { Text("Download CV") }
            }
        }
    }
}


@Composable
@Preview(widthDp = 1920, heightDp = 1080, showBackground = true)
fun ProfileSectionPreview() {
    HomeSection(
        Modifier.fillMaxSize(),
    )
}
