package com.uziro.portfolio.data.repository

import com.uziro.portfolio.data.SocialData
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.instagram
import uziroportfolio.composeapp.generated.resources.linkedIn
import uziroportfolio.composeapp.generated.resources.threads
import uziroportfolio.composeapp.generated.resources.tiktok
import uziroportfolio.composeapp.generated.resources.youtube

val socialMediaList = listOf(
    SocialData("LinkedIn", Res.drawable.linkedIn, "https://www.linkedin.com/in/ifauzii/"),
    SocialData("Instagram", Res.drawable.instagram, "https://www.instagram.com/uziro.id/"),
    SocialData("Threads", Res.drawable.threads, "https://www.threads.com/@uziro.id"),
    SocialData("Tiktok", Res.drawable.tiktok, "https://www.tiktok.com/@uziro.id"),
    SocialData("Youtube", Res.drawable.youtube, "https://www.youtube.com/@uziroid"),
)
