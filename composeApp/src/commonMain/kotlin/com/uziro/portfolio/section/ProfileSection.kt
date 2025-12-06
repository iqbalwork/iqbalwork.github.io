package com.uziro.portfolio.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.profile

@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        val uriHandler = LocalUriHandler.current

        // Left Side - Text
        Column(modifier = Modifier) {
            Text("""
                Hello,
                I'm Iqbal Fauzi
            """.trimIndent(), style = MaterialTheme.typography.displayLarge)

            Spacer(Modifier.height(16.dp))

            Text(
                "Android Engineer • Kotlin Multiplatform Enthusiast",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(16.dp))
            Text(
                """
                    I’m a Software Engineer based in Bandung, Indonesia.
                    Currently exploring Kotlin Multiplatform to build wider platform.
                """.trimIndent(),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = {
                    uriHandler.openUri("https://wa.me/6287822882668?text=Halo%20Iqbal%20Fauzi")
                }) {
                    Text("Contact Me")
                }
                OutlinedButton(onClick = {
                    uriHandler.openUri("https://docs.google.com/document/d/12_bC8Va-h_Gi1Z5pC3Ig1n4k2fEdiNWQyd5HOKFSigs/edit?usp=sharing")
                }) {
                    Text("Download CV")
                }
            }
        }

        Spacer(Modifier.width(60.dp))

        // Right side - Image
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
        )
    }
}
