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
import androidx.compose.material3.OutlinedButton
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
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.bobobox_port
import uziroportfolio.composeapp.generated.resources.compose_multiplatform
import uziroportfolio.composeapp.generated.resources.qbi

data class PortfolioItem(
    val title: String,
    val aboutProject: String,
    val role: String,
    val timeFrame: String,
    val overview: String,
    val keyFeature: String,
    val link: String,
    val image: Painter,
)

@Composable
fun PortfolioCard(
    project: PortfolioItem,
    modifier: Modifier = Modifier
) {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(20.dp)
            .clickable {
                uriHandler.openUri(project.link)
            }
            .border(
                BorderStroke(1.dp, Color(0xFFCCCCCC)),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        // IMAGE
        Image(
            painter = project.image,
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
            modifier = Modifier.padding(horizontal = 8.dp)
        )
//
//        Spacer(Modifier.height(12.dp))
//
//        Text(
//            "View Case Study ➜",
//            style = MaterialTheme.typography.labelLarge.copy(
//                color = Color.Black,
//                fontWeight = FontWeight.SemiBold
//            )
//        )
    }
}

@Composable
fun PortfolioSection(
    modifier: Modifier = Modifier
) {
    val projects = listOf(
        PortfolioItem(
            title = "Bobobox",
            image = painterResource(Res.drawable.bobobox_port),
            overview = "Bobobox is an Indonesian tech-integrated hospitality brand that redefines budget accommodation through its innovative capsule hotels and glamping experiences. Founded in 2017, Bobobox aims to provide affordable, comfortable, and high-tech stays for modern travelers. With a presence in major cities and nature destinations across Indonesia, it has become a go-to option for solo travelers, digital nomads, and adventurers seeking a balance of privacy, affordability, and convenience.",
            link = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox",
            aboutProject = "A modern capsul and cabin hotel with new technology enabled that can control the room by the app.",
            role = "Mobile Engineer",
            timeFrame = "Since 2020",
            keyFeature = ""
        ),
        PortfolioItem(
            title = "Quran Belajar Indonesia",
            image = painterResource(Res.drawable.qbi),
            overview = "Bobobox is an Indonesian tech-integrated hospitality brand that redefines budget accommodation through its innovative capsule hotels and glamping experiences. Founded in 2017, Bobobox aims to provide affordable, comfortable, and high-tech stays for modern travelers. With a presence in major cities and nature destinations across Indonesia, it has become a go-to option for solo travelers, digital nomads, and adventurers seeking a balance of privacy, affordability, and convenience.",
            link = "https://play.google.com/store/apps/details?id=id.quranbelajar.app",
            aboutProject = "A free, ad-free mobile app to help Indonesians read, understand, and listen to the Qur’an with ease.",
            role = "Mobile Engineer, Product Manager",
            timeFrame = "2021 - 2023",
            keyFeature = ""
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
            textAlign = TextAlign.Center
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

//        Spacer(Modifier.height(28.dp))
//
//        // ---- SEE ALL BUTTON ----
//        OutlinedButton(
//            onClick = {  },
//            shape = RoundedCornerShape(50),
//            border = BorderStroke(1.dp, Color.Black)
//        ) {
//            Text("See All Works")
//        }
    }
}


@Preview
@Composable
fun PreviewPortfolioSection(modifier: Modifier = Modifier) {
    PortfolioSection(modifier.fillMaxSize())
}
