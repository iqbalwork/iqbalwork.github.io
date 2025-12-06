package com.uziro.portfolio.ui.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.compose_multiplatform

data class PortfolioItem(
    val image: String,
    val title: String,
    val description: String,
    val link: String
)

@Composable
fun PortfolioCard(
    project: PortfolioItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(20.dp)
            .clickable { /* open project.link */ }
            .border(
                BorderStroke(1.dp, Color(0xFFCCCCCC)),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        // IMAGE
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = project.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(14.dp))
        )

        Spacer(Modifier.height(16.dp))

        // TITLE
        Text(
            project.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.height(6.dp))

        // DESCRIPTION
        Text(
            project.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.DarkGray
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "View Case Study ➜",
            style = MaterialTheme.typography.labelLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun PortfolioSection(
    modifier: Modifier = Modifier
) {
    val projects = listOf(
        PortfolioItem(
            image = "portfolio1.png",
            title = "Snowlake Social Media Website",
            description = "Snowlake is a sleek, product-driven site for a social media platform, built with clean UI and scalable Framer CMS.",
            link = "#"
        ),
        PortfolioItem(
            image = "portfolio2.png",
            title = "Meeko Company Networking Website",
            description = "Meeko is a modern Framer–built site connecting professionals, designed for seamless networking.",
            link = "#"
        ),
        PortfolioItem(
            image = "portfolio3.png",
            title = "Sandbox Banking Application Website",
            description = "A fintech site that spotlights trust and innovation through a powerful CMS.",
            link = "#"
        ),
        PortfolioItem(
            image = "portfolio4.png",
            title = "Creatink Website Portfolio Template",
            description = "Creatink showcases strong visuals and smooth UX, built on Framer CMS.",
            link = "#"
        ),
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ---- LABEL ----
        Text(
            text = "* MY WORKS",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(50)
                )
                .padding(horizontal = 14.dp, vertical = 6.dp)
        )

        Spacer(Modifier.height(20.dp))

        // ---- SECTION TITLE ----
        Text(
            text = "Check out some of our awesome\nprojects with creative ideas.",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(Modifier.height(40.dp))

        // ---- 2 COLUMN GRID ----
        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            projects.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.spacedBy(28.dp)
                ) {
                    rowItems.forEach { item ->
                        PortfolioCard(
                            project = item,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        // ---- SEE ALL BUTTON ----
        OutlinedButton(
            onClick = { /* TODO */ },
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text("See All Works")
        }
    }
}
