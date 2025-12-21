package com.uziro.portfolio.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.profile

@Composable
fun AboutSection(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFE7E2F2)) // soft lilac background seperti Meelo
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.width(1200.dp) // limit content like Meelo
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // -------------------------
                // LEFT: BIG CIRCLE PHOTO
                // -------------------------
                Box(
                    modifier = Modifier.size(420.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Background circle
                    Box(
                        modifier = Modifier
                            .size(380.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFB7A8CE)) // purple gradient base
                    )

                    // Profile Image
                    Image(
                        painter = painterResource(Res.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(360.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    // Decorative Wavy lines (Left)
                    Icon(
                        imageVector = Icons.Default.Waves, // Replace with custom doodle vector
                        contentDescription = null,
                        tint = Color.Black.copy(alpha = 0.5f),
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    )

                    // Circular badge on top-right
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(20.dp, (-20).dp)
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(2.dp, Color.Black, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Work Experience",
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Spacer(Modifier.width(60.dp))

                // -------------------------
                // RIGHT: ABOUT TEXT
                // -------------------------
                Column(modifier = Modifier.weight(1f)) {

                    Text(
                        "More about me",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(Modifier.height(12.dp))

                    Text(
                        """
                            Android Engineer with 7+ years of experience designing, developing, and scaling mobile applications. 
                            
                            Skilled in Kotlin, Jetpack Compose, MVVM/MVP, Firebase, GraphQL, and IoT integrations, with a track record of delivering apps with 99% crash-free rates and millions of users. 
                            
                            Currently adopting Kotlin Multiplatform (KMP) to expand capabilities across Android, iOS, and shared business logic. Experienced collaborating with cross-functional and remote teams across different time zones.
                        """.trimIndent(),
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 26.sp
                    )
                }
            }

            Spacer(Modifier.height(80.dp))

            // ---------------------------------------------------
            // BOTTOM SECTION: EXPERIENCES + TIMELINE (LEFT + RIGHT)
            // ---------------------------------------------------
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // Left text
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "My experiences",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "A timeline of my professional journey and key accomplishments in the tech industry.",
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 26.sp
                    )
                }

                Spacer(Modifier.width(60.dp))

                // Right timeline
                Column(modifier = Modifier.weight(1f)) {

                    ExperienceItem(
                        date = "Mar 2020 — PRESENT",
                        role = "Mobile Engineer at Bobobox",
                        desc = "Led major app modernization: architecture overhaul, Kotlin/Compose migration, reliability boost (crash-free 79% → 99%), GraphQL integration, IoT (MQTT) features, automated deployments, advanced UI features, and early KMP adoption for android-ios cross platform."
                    )

                    ExperienceItem(
                        date = "Oct 2021 — Nov 2023",
                        role = "Senior Android Engineer at Quran Belajar Indonesia",
                        desc = "Developed Quran app features: prayer times, Qibla navigation, floating Azan notifications, ayah highlighter (custom canvas). Optimized app performance and engagement, resulting in strong ratings on Google Play."
                    )

                    ExperienceItem(
                        date = "Feb 2019 — Mar 2020",
                        role = "Android Engineer at Jasamedika Saranatama",
                        desc = "Built healthcare apps including Buku Dokter and PSC 119 emergency app from scratch. Enhanced HRIS and Buku Akademik apps, ensuring scalability and performance."
                    )

                    ExperienceItem(
                        date = "Oct 2018 — Dec 2018",
                        role = "Junior Android Engineer at Kakatu",
                        desc = "Built an internal HRIS app; gained foundational experience in Android app architecture and modular design."
                    )
                }
            }
        }
    }
}


// -------------------------------
// TIMELINE ITEM
// -------------------------------
@Composable
fun ExperienceItem(date: String, role: String, desc: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        // DATE
        Text(
            date,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.width(150.dp)
        )

        // Circle + Vertical Line
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(2.dp, Color.Black, CircleShape)
            )
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(60.dp)
                    .background(Color.Black)
            )
        }

        Spacer(Modifier.width(20.dp))

        // Role + Description
        Column {
            Text(
                role,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                desc,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp
            )
        }
    }
}


@Composable
@Preview(widthDp = 1920, heightDp = 1080, showBackground = true)
fun AboutSectionPreview() {
    AboutSection(Modifier.fillMaxSize())
}
