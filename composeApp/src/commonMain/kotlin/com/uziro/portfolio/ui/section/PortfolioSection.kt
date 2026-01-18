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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.repository.projectList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PortfolioCard(
    project: Project,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .border(
                BorderStroke(1.dp, Color(0xFFCCCCCC)),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(20.dp)
    ) {
        // IMAGE
        Image(
            painter = painterResource(project.image),
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
            text = project.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(Modifier.height(6.dp))

        // DESCRIPTION
        Text(
            text = project.overview,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.DarkGray,
            maxLines = 3,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun PortfolioSection(
    modifier: Modifier = Modifier,
    onProjectClick: (Project) -> Unit = {}
) {
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
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(40.dp))

        // ---- 2 COLUMN GRID ----
        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            projectList.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.spacedBy(28.dp)
                ) {
                    rowItems.forEach { item ->
                        PortfolioCard(
                            project = item,
                            modifier = Modifier.weight(1f),
                            onClick = { onProjectClick(item) }
                        )
                    }
                    if (rowItems.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewPortfolioSection(modifier: Modifier = Modifier) {
    PortfolioSection(modifier.fillMaxSize())
}
