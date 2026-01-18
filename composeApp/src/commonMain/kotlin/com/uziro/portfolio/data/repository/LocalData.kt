package com.uziro.portfolio.data.repository

import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.SocialData
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.bobobox_port
import uziroportfolio.composeapp.generated.resources.compose_multiplatform
import uziroportfolio.composeapp.generated.resources.instagram
import uziroportfolio.composeapp.generated.resources.linkedIn
import uziroportfolio.composeapp.generated.resources.qbi
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

val projectList = listOf(
    Project(
        title = "Bobobox App",
        image = Res.drawable.bobobox_port,
        overview = "Leading Android engineering efforts since March 2020 for a tech-enabled accommodation platform. The role focuses on designing and scaling the mobile app, which serves thousands of daily active users and includes complex IoT integrations for controlling smart pods (lights, doors) directly from the user's device.",
        techStack = listOf(
            "Language: Kotlin (Migrated from Java), Kotlin Multiplatform (KMP)",
            "UI Toolkit: Jetpack Compose (Migrated from XML)",
            "Architecture: MVVM (Model-View-ViewModel), Multi-module structure",
            "Key Technologies: MQTT Protocol (IoT), Coroutines, Flow, Koin/Hilt"
        ),
        impact = listOf(
            "Stability: Drastically improved app stability, raising the crash-free rate from 79% to 99%",
            "Scalability: Successfully re-architected the legacy monolithic MVP codebase into a scalable, multi-module MVVM structure",
            "Efficiency: Accelerated feature delivery by migrating the codebase from Java to Kotlin and the UI to Jetpack Compose",
            "IoT Innovation: Enabled seamless control of physical room features (smart pods) via MQTT protocol implementation"
        ),
        nextPlan = listOf(
            "Cross-Platform Expansion: Actively adopting Kotlin Multiplatform (KMP) to unify business logic and expand development capabilities across both Android and iOS platforms"
        ),
        url = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox"
    ),
    Project(
        title = "Talangraga Umroh App",
        image = Res.drawable.compose_multiplatform,
        overview = "A digital savings management application developed for Padepokan Talangraga to streamline their collective Umroh savings program. The app was created to replace manual tracking methods (spreadsheets and chat logs) with a centralized, transparent digital system for members and administrators.",
        techStack = listOf(
            "Platform: Kotlin Multiplatform (KMP) for shared logic across Android & iOS",
            "UI Framework: Compose Multiplatform (Material 3)",
            "Architecture: Clean Architecture with MVVM (Model-View-ViewModel)",
            "Networking & Backend: Ktor Client communicating with a Python FastAPI backend",
            "Database: SQLDelight (Multiplatform local database)"
        ),
        impact = listOf(
            "Digital Transformation: Successfully digitized the manual savings process, reducing errors and increasing transparency between members and admins",
            "Cross-Platform Efficiency: Achieved a unified codebase for both Android and iOS using KMP and Compose Multiplatform, significantly reducing development time",
            "Feature Implementation: Delivered key features including a Member Dashboard (real-time savings progress), Transaction Management, and an Admin Panel"
        ),
        nextPlan = listOf(
            "Production Release: Finalize the Beta development phase and internal testing to prepare for an official release on the Google Play Store and Apple App Store",
            "License Definition: Define the open-source or proprietary license model following the successful internal rollout"
        ),
        url = "https://github.com/iqbalwork/talangraga-umroh-mobile"
    ),
    Project(
        title = "Quran Belajar Indonesia",
        image = Res.drawable.qbi,
        overview = "Served as an Android Engineer from October 2021 to November 2023. The main focus was modernizing the Quran Belajar Indonesian application to improve stability and user experience.",
        techStack = listOf(
            "Language: Kotlin (Migrated from Java)",
            "Architecture: Multi-module (Migrated from single module)",
            "Key Technologies: Work Manager & Alarm Manager (for background services), Coordinate Calculation for image scaling"
        ),
        impact = listOf(
            "Rapid Stability Fix: Increased the crash-free rate from 82% to 99% within just 3 months",
            "Modernization: Led the complete re-architecture and migration of the app from Java to Kotlin and from a single module to a scalable multi-module structure",
            "Feature Engineering: Implemented a complex verse highlighting feature by calculating X & Y coordinates relative to device resolution and added prayer time calculations using background services"
        ),
        url = "https://play.google.com/store/apps/details?id=id.quranbelajar.app"
    ),
    Project(
        title = "PSC 119 & Buku Akademik",
        image = Res.drawable.compose_multiplatform,
        overview = "Worked as an Android Engineer at PT Jasamedika Saranatama (Feb 2019 – Mar 2020). The role involved building healthcare and emergency response applications from scratch while maintaining academic information systems.",
        techStack = listOf(
            "Architecture: Multi-module architecture",
            "Dependency Injection: Koin (integrated as a Dagger2 alternative)",
            "Key Technologies: Mapbox (Navigation), Java & Kotlin"
        ),
        impact = listOf(
            "New Product Development: Built the PSC 119 emergency app and Buku Dokter entirely from scratch",
            "Critical Features: Integrated Mapbox into the PSC 119 app to enable navigation for ambulance drivers",
            "Performance Optimization: Enhanced the HRIS and Buku Akademik apps to ensure better scalability and performance"
        )
    ),
    Project(
        title = "Simple HRIS (Kakatu / PT Kinest Kreatif Ideata)",
        image = Res.drawable.compose_multiplatform,
        overview = "Started as a Junior Android Engineer (Oct 2018 – Dec 2018), gaining foundational experience by building an internal tool for Human Resources.",
        techStack = listOf(
            "Architecture: Android Architecture fundamentals, Modular Design",
            "Networking: Retrofit",
            "Concepts: Dependency Injection"
        ),
        impact = listOf(
            "App Creation: Successfully built an internal HRIS application",
            "Skill Acquisition: Gained core competency in Android architecture, modular design, and API integration using Retrofit"
        )
    )
)
