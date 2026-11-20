package com.uziro.portfolio.data.repository

import com.uziro.portfolio.data.AdditionalProfileInfo
import com.uziro.portfolio.data.EducationItem
import com.uziro.portfolio.data.ExperienceItem
import com.uziro.portfolio.data.ExperiencePhase
import com.uziro.portfolio.data.MetricStat
import com.uziro.portfolio.data.PlayPortfolioLink
import com.uziro.portfolio.data.ProfileInfo
import com.uziro.portfolio.data.Project
import com.uziro.portfolio.data.SkillCategory
import com.uziro.portfolio.data.SocialData
import uziroportfolio.composeapp.generated.resources.Res
import uziroportfolio.composeapp.generated.resources.bobobox_port
import uziroportfolio.composeapp.generated.resources.compose_multiplatform
import uziroportfolio.composeapp.generated.resources.githublogo
import uziroportfolio.composeapp.generated.resources.instagram
import uziroportfolio.composeapp.generated.resources.linkedIn
import uziroportfolio.composeapp.generated.resources.qbi
import uziroportfolio.composeapp.generated.resources.robithoh_port
import uziroportfolio.composeapp.generated.resources.threads
import uziroportfolio.composeapp.generated.resources.tiktok
import uziroportfolio.composeapp.generated.resources.wa
import uziroportfolio.composeapp.generated.resources.youtube

val profileInfo = ProfileInfo(
    name = "Iqbal Fauzi",
    title = "Android Engineer | Kotlin Multiplatform",
    location = "Bandung, Indonesia",
    email = "work.iqbalfauzi@gmail.com",
    phone = "+62 878 2288 2668",
    summary = "Experienced Android Engineer with 7+ years of experience across scaling mobile application projects. Skilled in Kotlin, Jetpack Compose, MVVM/MVP/MVI, Firebase, GraphQL, and IoT integrations, with a track record of handling complex, mature apps serving 1 million+ users. Currently adopting Kotlin Multiplatform (KMP) to unify capabilities across Android, iOS, and shared business logic.",
    whatsappUrl = "https://wa.me/6287822882668",
    cvUrl = "https://docs.google.com/document/d/12_bC8Va-h_Gi1Z5pC3Ig1n4k2fEdiNWQyd5HOKFSigs/edit?usp=sharing",
    linkedinUrl = "https://www.linkedin.com/in/ifauzii/",
    githubUrl = "https://github.com/iqbalwork",
    portfolioUrl = "https://iqbalwork.github.io"
)

val keyStats = listOf(
    MetricStat(
        value = "7+ Yrs",
        label = "Mobile Engineering",
        description = "Architecting and scaling consumer & enterprise Android products",
        highlight = "Kotlin & Compose"
    ),
    MetricStat(
        value = "1M+",
        label = "Apps Audience",
        description = "Production apps serving 60K MAU on Bobobox & 200K MAU on Quran App",
        highlight = "High Concurrency"
    ),
    MetricStat(
        value = "99.9%",
        label = "Crash-Free Rate",
        description = "Proactive Firebase Crashlytics monitoring & Maestro E2E automation",
        highlight = "99% Bug Reduction"
    ),
    MetricStat(
        value = "3 Targets",
        label = "Unified Stack",
        description = "KMP mobile unification (Android & iOS) & cross-platform Remote Config",
        highlight = "Android · iOS · Web"
    )
)

val experienceList = listOf(
    ExperienceItem(
        company = "PT Bobobox Mitra Indonesia",
        role = "Senior Android Engineer",
        period = "Mar 2020 – Present",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Driving mobile architecture, cross-platform Kotlin Multiplatform unification, IoT smart pod experiences, and AI-assisted engineering standards.",
        phases = listOf(
            ExperiencePhase(
                title = "Senior Android Engineer · Platform Unification, KMP & AI Harness",
                period = "Mar 2020 – Present",
                achievements = listOf(
                    "Unified Mobile App for Android & iOS with Kotlin Multiplatform (KMP).",
                    "Unified Remote Config platform across Android, iOS, and Web.",
                    "Improved BPad application code cleanliness and maintainability.",
                    "Built AI Harness standard for the Tech Team in collaboration with the CTO."
                )
            ),
            ExperiencePhase(
                title = "Android Engineer · Core Android Architecture, IoT & Scale",
                period = "Mar 2020 – Jul 2026",
                achievements = listOf(
                    "Led re-architecture of Bobobox App from MVP to MVVM and single to multi-module structure, reducing maintenance overhead while achieving an 8.5/10.0 NPS score and 60K Monthly Active Users.",
                    "Implemented comprehensive crash monitoring using Firebase Crashlytics, proactively resolving production issues to sustain 99.9% stability.",
                    "Implemented IoT features (MQTT protocol) enabling seamless control of smart pods (doors and ambient lighting).",
                    "Began adopting Kotlin Multiplatform (KMP) for cross-platform Android & iOS shared logic.",
                    "Reduced Google Maps display feature cost by 50%.",
                    "Mentored junior engineers and helped mobile teams establish strategic team charters.",
                    "Introduced and trained the QA team on Automation Testing with Maestro.",
                    "Led AI-Assisted Engineering Standards with the CTO for the engineering organization."
                )
            )
        ),
        technologies = listOf(
            "Kotlin", "Jetpack Compose", "Kotlin Multiplatform", "Swift",
            "MQTT (IoT)", "Multi-Module MVVM", "Firebase Crashlytics",
            "Remote Config", "Maestro", "Coroutines & Flow", "Hilt / Koin"
        ),
        metrics = listOf("99.9% Stability", "60K MAU", "8.5/10 NPS", "50% Maps Cost Cut", "Android + iOS + Web")
    ),
    ExperienceItem(
        company = "PT Al Qosbah Inovasi Digital",
        role = "Senior Android Engineer Consultant",
        period = "Oct 2021 – Nov 2023",
        location = "Bandung, Indonesia",
        type = "Part Time",
        description = "Consulted on strategic architectural improvements, pixel-perfect Quran rendering, and battery-efficient background scheduling.",
        achievements = listOf(
            "Contributed to strategic development planning by identifying and implementing key architectural improvements, resulting in a 99% reduction in application bugs within 3 months, accelerated 6-month release cycles, and growth to 200K Monthly Active Users in a year.",
            "Consulted on and implemented advanced UI features, including Quran Verse Highlighting with spatial calculations (computing X & Y coordinates from original image resolution and device scaling) for pixel-perfect display across devices.",
            "Designed and integrated robust background service capabilities for prayer time calculation using WorkManager and AlarmManager with resource-efficient scheduling."
        ),
        technologies = listOf(
            "Kotlin", "Multi-Module", "Spatial X/Y Coordinate Math",
            "WorkManager", "AlarmManager", "Background Processing"
        ),
        metrics = listOf("99% Bug Reduction", "200K MAU", "Pixel-Perfect Spatial UI")
    ),
    ExperienceItem(
        company = "PT Jasamedika Saranatama",
        role = "Android Engineer",
        period = "Feb 2019 – Mar 2020",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Engineered healthcare and emergency dispatch applications from scratch with modular architecture and real-time routing.",
        achievements = listOf(
            "Engineered healthcare applications (Buku Dokter, PSC 119) from scratch utilizing multi-module architecture and Koin dependency injection.",
            "Integrated Mapbox routing for real-time ambulance navigation within the PSC 119 emergency response application.",
            "Migrated legacy Java codebases to Kotlin, accelerating development cycles.",
            "Enhanced performance and scalability across internal HRIS and academic applications."
        ),
        technologies = listOf("Kotlin", "Java", "Mapbox SDK", "Multi-Module", "Koin DI", "Real-Time Tracking"),
        metrics = listOf("PSC 119 Emergency Launch", "Java-to-Kotlin Migration")
    ),
    ExperienceItem(
        company = "PT Kinest Kreatif Ideata",
        role = "Junior Android Engineer",
        period = "Oct 2018 – Dec 2018",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Developed an internal HRIS Android application implementing modular design, dependency injection, and REST synchronization.",
        achievements = listOf(
            "Developed an internal HRIS Android application implementing modular design and core Android architecture.",
            "Applied Dependency Injection to establish a scalable and maintainable codebase.",
            "Integrated REST APIs via Retrofit for reliable client-server data synchronization."
        ),
        technologies = listOf("Android SDK", "Retrofit", "REST APIs", "Dependency Injection", "Modular Design"),
        metrics = listOf("Internal HRIS Release")
    )
)

val skillCategories = listOf(
    SkillCategory(
        name = "Mobile Development & Frameworks",
        iconKey = "mobile",
        skills = listOf(
            "Kotlin", "Java", "Swift", "Jetpack Compose", "Compose Multiplatform",
            "Kotlin Multiplatform (KMP)", "Android Jetpack (Compose, Navigation, Room)",
            "MVVM", "MVI", "Clean Architecture", "Coroutines", "Flow",
            "Dagger2", "Hilt", "Koin", "WorkManager", "Background Processing",
            "Widget", "Modular Architecture", "SDK Development", "Coil",
            "SQLDelight", "ViewModel", "LiveData"
        ),
        highlight = "7+ Years Native Android & KMP Mastery"
    ),
    SkillCategory(
        name = "Backend & Cloud Integrations",
        iconKey = "cloud",
        skills = listOf(
            "RESTful APIs", "GraphQL Integration", "Firebase", "MQTT",
            "Ktor", "Push Notifications", "Strapi", "FastAPI"
        ),
        highlight = "IoT MQTT, GraphQL & Multiplatform Networking"
    ),
    SkillCategory(
        name = "Testing & Quality",
        iconKey = "testing",
        skills = listOf(
            "JUnit", "Mockito", "Kotlin Test", "Unit Testing",
            "UI Testing", "Espresso", "Maestro (Automation)", "Code Review", "TDD"
        ),
        highlight = "99.9% Crash-Free Engineering Discipline"
    ),
    SkillCategory(
        name = "Advanced Features & Optimization",
        iconKey = "optimization",
        skills = listOf(
            "A/B Testing", "Performance Optimization", "Real-Time Tracking",
            "QR Code Scanning", "Mobile Security", "System Design",
            "Software Architecture", "Dependency Injection", "User Experience (UX)",
            "IoT", "Remote Configuration"
        ),
        highlight = "Unified Remote Config & High-Scale Systems"
    ),
    SkillCategory(
        name = "Tools & Methodologies",
        iconKey = "tools",
        skills = listOf(
            "Git", "GitHub", "GitLab", "Gradle", "Jira", "Agile", "Scrum", "Postman"
        ),
        highlight = "Distributed & Async Team Workflows"
    ),
    SkillCategory(
        name = "Leadership & Project Management",
        iconKey = "leadership",
        skills = listOf(
            "Technical Leadership", "Mentorship", "Project Management",
            "Product Management", "AI Harness Standards", "Team Charters"
        ),
        highlight = "CTO-Aligned AI Harness & Mobile Mentoring"
    )
)

val projectList = listOf(
    Project(
        title = "Robithoh",
        category = "Kotlin Multiplatform (KMP)",
        image = Res.drawable.robithoh_port,
        overview = "Modern multiplatform TQN Suryalaya Sirnarasa worship and amaliyah companion app (v2.0.0) built 100% offline-first with zero ads. Features the 604-page Kemenag RI Quran Mushaf, precise prayer schedules, Qibla compass, haptic 165x digital tasbih, interactive home-screen widgets, and worldwide Wakil Talqin directory.",
        techStack = listOf(
            "Kotlin Multiplatform & Compose Multiplatform",
            "Robithoh Design System (Material 3)",
            "Jetpack Glance (8 Interactive Home Widgets)",
            "Navigation 3 & Predictive Back",
            "100% Offline-First Local Engine",
            "Android (Google Play) & iOS / Safari Web App"
        ),
        impact = listOf(
            "Offline-First Engine: Engineered a 100% offline-first architecture with zero ads, delivering 604-page Kemenag RI Mushaf vector rendering and 38 amaliyah chapters",
            "Multiplatform Release: Shipped v2.0.0 across Android (Google Play, Android 7.0-15+) and iOS / Safari Web App (robithoh-app.vercel.app)",
            "Interactive Android Widgets: Built 8 Jetpack Glance home-screen widget variants (Prayer Schedule 4x2/4x1 & Digital Tasbih 2x2/4x1) with automatic WidgetSync",
            "Trilingual & v2.0.0 Updates: Delivered Kitab Manqobah 1-56 in Arabic, Indonesian & Sundanese, Worldwide Wakil Talqin Directory, Official Maklumat & independent Adhan volume"
        ),
        nextPlan = listOf(
            "Expanding digital khidmah features and cross-platform experience across Android and iOS Web App"
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=com.iqbalwork.robithoh",
        url = "https://robithoh.vercel.app/"
    ),
    Project(
        title = "Bobobox App",
        category = "Hospitality & IoT",
        image = Res.drawable.bobobox_port,
        overview = "Flagship tech-enabled accommodation platform serving 60K monthly active users. Evolved from legacy MVP into a multi-module MVVM & Kotlin Multiplatform ecosystem unifying Android & iOS, paired with cross-platform Remote Config and real-time MQTT smart pod hardware control.",
        techStack = listOf(
            "Kotlin & Jetpack Compose",
            "Kotlin Multiplatform (Android & iOS Unification)",
            "Unified Remote Config (Android, iOS & Web)",
            "MQTT Protocol (Smart Pod Doors & Lights)",
            "Multi-Module MVVM Architecture",
            "Firebase Crashlytics (99.9% Stability)",
            "Maestro Automated E2E Testing"
        ),
        impact = listOf(
            "Cross-Platform Unification: Unified Android & iOS mobile app with Kotlin Multiplatform and unified Remote Config across Android, iOS, and Web",
            "Stability & Cleanliness: Maintained 99.9% crash-free stability via Firebase Crashlytics and improved BPad app code cleanliness",
            "Scalability & Satisfaction: Re-architected MVP to multi-module MVVM with 8.5/10.0 NPS score and 60,000 Monthly Active Users",
            "IoT & Cost Efficiency: Delivered real-time MQTT smart pod control and reduced Google Maps display costs by 50%",
            "Engineering Excellence: Built the Tech Team AI Harness standard in collaboration with the CTO"
        ),
        nextPlan = listOf(
            "Expanding shared KMP modules and AI-assisted engineering harness workflows across product teams"
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox",
        url = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox"
    ),
    Project(
        title = "Quran Belajar Indonesia",
        category = "Education & Utility",
        image = Res.drawable.qbi,
        overview = "Served as Senior Android Engineer Consultant at PT Al Qosbah Inovasi Digital to modernize architecture, drastically reduce defects, and build a pixel-perfect spatial verse highlighting engine across diverse Android devices.",
        techStack = listOf(
            "Kotlin Multi-Module",
            "Spatial X/Y Coordinate Scaling Engine",
            "WorkManager & AlarmManager",
            "Resource-Efficient Background Services",
            "Clean Architecture"
        ),
        impact = listOf(
            "Rapid Bug Reduction: Reduced application bugs by 99% within 3 months and accelerated development-to-release within 6 months",
            "Audience Scale: Scaled to 200,000+ Monthly Active Users within one year",
            "Spatial Highlighting: Computed exact X & Y verse bounding coordinates from source image resolution and device scaling",
            "Prayer Time Engine: Engineered reliable WorkManager & AlarmManager scheduling"
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=id.quranbelajar.app",
        url = "https://play.google.com/store/apps/details?id=id.quranbelajar.app"
    ),
    Project(
        title = "Talangraga Umroh App",
        category = "Kotlin Multiplatform (KMP)",
        image = Res.drawable.compose_multiplatform,
        overview = "A digital savings and community management application developed using Kotlin Multiplatform and Compose Multiplatform to streamline the Umroh collective savings program with a centralized, transparent ledger.",
        techStack = listOf(
            "Kotlin Multiplatform (Shared KMP Logic)",
            "Compose Multiplatform (Material 3 UI)",
            "Ktor HTTP Client",
            "SQLDelight Multiplatform Database",
            "Python FastAPI Backend"
        ),
        impact = listOf(
            "Cross-Platform Unity: Shared business logic and unified Compose UI across Android and iOS",
            "Transparent Ledger: Digitized manual savings logs with real-time member dashboards and verification",
            "Modern Stack: Leveraged SQLDelight for offline persistence and Ktor for resilient network sync"
        ),
        githubUrl = "https://github.com/iqbalwork/talangraga-umroh-mobile",
        url = "https://github.com/iqbalwork/talangraga-umroh-mobile"
    ),
    Project(
        title = "PSC 119 & Buku Dokter",
        category = "Healthcare & Emergency",
        image = Res.drawable.compose_multiplatform,
        overview = "Engineered healthcare and emergency response applications from scratch at PT Jasamedika Saranatama, connecting ambulance drivers with hospital emergency teams using real-time Mapbox navigation.",
        techStack = listOf(
            "Kotlin & Java",
            "Mapbox Navigation SDK",
            "Multi-Module Architecture",
            "Koin Dependency Injection",
            "Real-Time GPS Tracking"
        ),
        impact = listOf(
            "Emergency Dispatch: Enabled real-time Mapbox routing for ambulance navigation in PSC 119",
            "From-Scratch Architecture: Engineered Buku Dokter and PSC 119 with multi-module design and Koin DI",
            "Codebase Modernization: Migrated legacy Java codebases to Kotlin and boosted internal HRIS/academic performance"
        )
    ),
    Project(
        title = "Internal HRIS (Kinest)",
        category = "Enterprise Tools",
        image = Res.drawable.compose_multiplatform,
        overview = "Developed an internal Human Resource Information System Android application at PT Kinest Kreatif Ideata implementing modular design, dependency injection, and RESTful synchronization via Retrofit.",
        techStack = listOf(
            "Android SDK",
            "Retrofit",
            "Dependency Injection",
            "Modular Architecture"
        ),
        impact = listOf(
            "Modular Foundation: Established scalable architecture with Dependency Injection",
            "Reliable Sync: Integrated RESTful APIs via Retrofit for dependable client-server synchronization"
        )
    )
)

val educationInfo = EducationItem(
    degree = "Bachelor of Informatics Engineering",
    institution = "Universitas Siliwangi – Indonesia",
    location = "Tasikmalaya",
    period = "Sep 2014 – Aug 2018",
    description = "Graduated in Informatics Engineering with foundational focus on Software Engineering, Algorithms, and Mobile Application Development."
)

val additionalProfileInfo = AdditionalProfileInfo(
    asyncCollaboration = "Experienced in async collaboration tools (Slack, Jira, GitHub) and working effectively with distributed engineering teams.",
    playStoreLinks = listOf(
        PlayPortfolioLink(
            title = "Robithoh",
            subtitle = "TQN Worship & Amaliyah · KMP Offline-First",
            url = "https://play.google.com/store/apps/details?id=com.iqbalwork.robithoh"
        ),
        PlayPortfolioLink(
            title = "Bobobox App",
            subtitle = "Hospitality, IoT Smart Pod & KMP",
            url = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox"
        ),
        PlayPortfolioLink(
            title = "Quran App",
            subtitle = "Quran Belajar Indonesia · 200K+ MAU",
            url = "https://play.google.com/store/apps/details?id=id.quranbelajar.app"
        )
    )
)

val socialMediaList = listOf(
    SocialData("LinkedIn", Res.drawable.linkedIn, "https://www.linkedin.com/in/ifauzii/"),
    SocialData("GitHub", Res.drawable.githublogo, "https://github.com/iqbalwork"),
    SocialData("WhatsApp", Res.drawable.wa, "https://wa.me/6287822882668"),
    SocialData("Instagram", Res.drawable.instagram, "https://www.instagram.com/uziro.id/"),
    SocialData("Threads", Res.drawable.threads, "https://www.threads.com/@uziro.id"),
    SocialData("TikTok", Res.drawable.tiktok, "https://www.tiktok.com/@uziro.id"),
    SocialData("YouTube", Res.drawable.youtube, "https://www.youtube.com/@uziroid")
)
