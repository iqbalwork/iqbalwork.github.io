package com.uziro.portfolio.data.repository

import com.uziro.portfolio.data.EducationItem
import com.uziro.portfolio.data.ExperienceItem
import com.uziro.portfolio.data.MetricStat
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
import uziroportfolio.composeapp.generated.resources.profile
import uziroportfolio.composeapp.generated.resources.profile_photo
import uziroportfolio.composeapp.generated.resources.qbi
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
    summary = "Experienced Android Engineer with 7+ years of experience through many scaling mobile application projects. Skilled in Kotlin, Jetpack Compose, MVVM/MVP/MVI, Firebase, GraphQL, and IoT integrations, with a track record of handling complex and mature apps with 1 million+ users. Currently adopting Kotlin Multiplatform (KMP) to expand capabilities across Android, iOS, and shared business logic.",
    whatsappUrl = "https://wa.me/6287822882668",
    cvUrl = "https://docs.google.com/document/d/12_bC8Va-h_Gi1Z5pC3Ig1n4k2fEdiNWQyd5HOKFSigs/edit?usp=sharing",
    linkedinUrl = "https://www.linkedin.com/in/ifauzii/",
    githubUrl = "https://github.com/iqbalwork"
)

val keyStats = listOf(
    MetricStat(
        value = "7+ Years",
        label = "Professional Experience",
        description = "Building scalable mobile architectures across enterprise and consumer products",
        highlight = "Kotlin & Compose Specialist"
    ),
    MetricStat(
        value = "1M+ Users",
        label = "Total Apps Audience",
        description = "Production applications delivered with high concurrency and reliability",
        highlight = "60K MAU on Bobobox"
    ),
    MetricStat(
        value = "99.9%",
        label = "Crash-Free Stability",
        description = "Proactive crash monitoring via Firebase Crashlytics & rigorous QA",
        highlight = "99% Bug Reduction"
    ),
    MetricStat(
        value = "4+ Scaled",
        label = "Enterprise Projects",
        description = "Hospitality IoT, Digital Quran, Healthcare, and Cross-Platform KMP",
        highlight = "KMP & Compose Multiplatform"
    )
)

val experienceList = listOf(
    ExperienceItem(
        company = "PT Bobobox Mitra Indonesia",
        role = "Android Engineer",
        period = "Mar 2020 – Present",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Leading Android engineering efforts for a tech-enabled accommodation platform with tens of thousands of active guests.",
        achievements = listOf(
            "Led re-architecture of Bobobox App from MVP → MVVM and single → multi-module structure, improving scalability and maintainability while achieving 8.5/10.0 NPS and 60K MAU.",
            "Implemented comprehensive crash monitoring using Firebase Crashlytics, proactively resolving production bugs to maintain 99.9% stability.",
            "Engineered IoT features using MQTT protocol to enable direct smart pod control (doors, lights, ambiance) from the mobile app.",
            "Began adopting Kotlin Multiplatform (KMP) for cross-platform Android & iOS shared business logic.",
            "Reduced feature cost by 50% for Google Maps display on the application.",
            "Mentored junior engineers and helped mobile teams establish team charters for strategic roles.",
            "Introduced automated end-to-end testing with Maestro to empower the QA team.",
            "Led AI-Assisted Engineering Standards in collaboration with the CTO for the entire engineering organization."
        ),
        technologies = listOf("Kotlin", "Jetpack Compose", "KMP", "MQTT Protocol (IoT)", "Multi-Module MVVM", "Firebase Crashlytics", "Maestro", "Coroutines & Flow", "Hilt/Koin"),
        metrics = listOf("99.9% Stability", "60K MAU", "8.5/10 NPS", "50% Maps Cost Cut")
    ),
    ExperienceItem(
        company = "PT Al Qosbah Inovasi Digital",
        role = "Senior Android Engineer Consultant",
        period = "Oct 2021 – Nov 2023",
        location = "Bandung, Indonesia",
        type = "Part Time",
        description = "Consulted on architectural improvements and advanced UI features for Quran Belajar Indonesia.",
        achievements = listOf(
            "Contributed to strategic development planning, resulting in a 99% reduction in application bugs within 3 months and scaling to 200K MAU in one year.",
            "Designed and implemented unique spatial coordinate calculations for verse highlighting, computing dynamic X & Y coordinates based on source image resolution and device scaling for pixel-perfect multi-device rendering.",
            "Engineered robust background service architecture for precision prayer time calculations using WorkManager and AlarmManager with resource-efficient scheduling."
        ),
        technologies = listOf("Kotlin", "Multi-Module", "Custom Canvas Spatial Math", "WorkManager", "AlarmManager", "Background Services"),
        metrics = listOf("99% Bug Reduction", "200K MAU", "Pixel-Perfect Dynamic Spatial UI")
    ),
    ExperienceItem(
        company = "PT Jasamedika Saranatama",
        role = "Android Engineer",
        period = "Feb 2019 – Mar 2020",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Engineered healthcare and emergency response applications from scratch.",
        achievements = listOf(
            "Engineered healthcare applications (Buku Dokter, PSC 119) from scratch utilizing multi-module architecture and Koin dependency injection.",
            "Integrated Mapbox routing for real-time ambulance dispatch and navigation within the PSC 119 emergency response system.",
            "Migrated legacy Java codebases to Kotlin, accelerating feature development velocity.",
            "Enhanced performance and scalability across internal HRIS and academic applications."
        ),
        technologies = listOf("Kotlin", "Java", "Mapbox SDK", "Multi-Module", "Koin DI", "Healthcare Systems"),
        metrics = listOf("PSC 119 Emergency Launch", "Java → Kotlin Migration")
    ),
    ExperienceItem(
        company = "PT Kinest Kreatif Ideata",
        role = "Junior Android Engineer",
        period = "Oct 2018 – Dec 2018",
        location = "Bandung, Indonesia",
        type = "Full Time",
        description = "Developed internal HRIS Android application implementing core Android architecture.",
        achievements = listOf(
            "Developed an internal HRIS Android application implementing modular design and core Android architectural patterns.",
            "Applied Dependency Injection to establish a scalable and maintainable codebase.",
            "Integrated RESTful APIs via Retrofit for reliable client-server data synchronization."
        ),
        technologies = listOf("Android SDK", "Retrofit", "REST APIs", "Dependency Injection", "Modular Design"),
        metrics = listOf("Internal HRIS Release")
    )
)

val skillCategories = listOf(
    SkillCategory(
        name = "Mobile Development & Frameworks",
        iconName = "phone",
        skills = listOf(
            "Kotlin", "Java", "Swift", "Jetpack Compose", "Compose Multiplatform",
            "Kotlin Multiplatform (KMP)", "Android Jetpack (Navigation, Room)",
            "MVVM / MVI / MVP", "Clean Architecture", "Coroutines & Flow",
            "Dagger2 / Hilt / Koin", "WorkManager", "SQLDelight", "Coil"
        ),
        highlight = "7+ Years Native & Multiplatform Expertise"
    ),
    SkillCategory(
        name = "Backend & Cloud Integrations",
        iconName = "cloud",
        skills = listOf(
            "RESTful APIs", "GraphQL Integration", "Firebase Suite (Crashlytics, Auth, RemoteConfig)",
            "MQTT Protocol (IoT)", "Ktor Client", "Push Notifications (FCM)", "FastAPI", "Strapi"
        ),
        highlight = "IoT MQTT & Realtime Cloud Services"
    ),
    SkillCategory(
        name = "Testing & Quality Assurance",
        iconName = "check",
        skills = listOf(
            "Maestro (E2E Automation)", "Espresso", "JUnit", "Mockito",
            "Kotlin Test", "Code Review", "Test-Driven Development (TDD)", "Crash Analysis"
        ),
        highlight = "99.9% Production Crash-Free Standards"
    ),
    SkillCategory(
        name = "Architecture & Systems Design",
        iconName = "architecture",
        skills = listOf(
            "Multi-Module Architecture", "SDK Development", "Performance Optimization",
            "A/B Testing", "Real-Time Tracking & Mapbox", "QR Code Scanning",
            "Mobile Security", "Spatial UI Calculations", "Resource-Efficient Scheduling"
        ),
        highlight = "Enterprise Modular App Architectures"
    ),
    SkillCategory(
        name = "Leadership & Tooling",
        iconName = "leadership",
        skills = listOf(
            "Technical Leadership", "Engineer Mentorship", "AI-Assisted Engineering Standards",
            "Git / GitHub / GitLab", "Gradle Build Optimization", "Jira / Agile / Scrum", "Postman"
        ),
        highlight = "AI-Assisted Workflow Standard Lead"
    )
)

val projectList = listOf(
    Project(
        title = "Bobobox App",
        category = "Hospitality & IoT",
        image = Res.drawable.bobobox_port,
        overview = "Leading Android engineering efforts since March 2020 for a tech-enabled accommodation platform. The role focuses on designing and scaling the mobile app, which serves 60K monthly active users and includes complex IoT integrations for controlling smart pods (lights, doors) directly from the guest's device.",
        techStack = listOf(
            "Kotlin (Migrated from Java)",
            "Jetpack Compose (Modern Declarative UI)",
            "Kotlin Multiplatform (KMP Shared Logic)",
            "MQTT Protocol (Real-time Smart Pod IoT)",
            "Multi-Module MVVM Architecture",
            "Firebase Crashlytics (99.9% Stability)",
            "Maestro Automated Testing"
        ),
        impact = listOf(
            "Stability: Raised crash-free user rate from 79% to 99.9% with proactive crash monitoring",
            "Scalability: Successfully re-architected the legacy monolithic MVP codebase into a scalable, multi-module MVVM structure",
            "IoT Innovation: Enabled seamless, instant control of physical pod doors and ambient smart lighting via MQTT",
            "Cost Efficiency: Reduced Google Maps API feature costs by 50% through optimized caching and rendering",
            "User Satisfaction: Achieved an 8.5 out of 10.0 NPS score with over 60,000 Monthly Active Users"
        ),
        nextPlan = listOf(
            "Cross-Platform Expansion: Expanding Kotlin Multiplatform (KMP) to unify business logic across Android and iOS"
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox",
        url = "https://play.google.com/store/apps/details?id=com.bobobox.bobobox"
    ),
    Project(
        title = "Quran Belajar Indonesia",
        category = "Education & Utility",
        image = Res.drawable.qbi,
        overview = "Served as Senior Android Engineer Consultant. Modernized the Quran Belajar Indonesia application to improve stability, user experience, and deliver precise verse highlighting across hundreds of Android screen resolutions.",
        techStack = listOf(
            "Kotlin Multi-Module",
            "Custom Spatial X/Y Coordinate Calculations",
            "WorkManager & AlarmManager",
            "Background Service Architecture",
            "Clean Architecture"
        ),
        impact = listOf(
            "Rapid Bug Reduction: Reduced application crashes and bugs by 99% within the first 3 months",
            "Audience Growth: Scaled to 200,000+ Monthly Active Users within a single year",
            "Spatial Highlighting: Implemented a pixel-perfect Quran verse highlighting engine calculating exact X & Y coordinates based on original image resolution and device scaling",
            "Reliable Background Engine: Engineered battery-friendly prayer time calculation services with accurate notification triggers"
        ),
        playStoreUrl = "https://play.google.com/store/apps/details?id=id.quranbelajar.app",
        url = "https://play.google.com/store/apps/details?id=id.quranbelajar.app"
    ),
    Project(
        title = "Talangraga Umroh App",
        category = "Kotlin Multiplatform (KMP)",
        image = Res.drawable.compose_multiplatform,
        overview = "A digital savings and community management application developed using Kotlin Multiplatform and Compose Multiplatform to streamline the Umroh collective savings program with a centralized, transparent system.",
        techStack = listOf(
            "Kotlin Multiplatform (Shared KMP Logic)",
            "Compose Multiplatform (Material 3 UI)",
            "Ktor HTTP Client",
            "SQLDelight Multiplatform Database",
            "Python FastAPI Backend"
        ),
        impact = listOf(
            "Cross-Platform Unity: 100% shared business logic and unified Compose UI across Android and iOS",
            "Transparent Ledger: Digitized manual savings logs with real-time member dashboards and admin verification",
            "Modern Stack: Leveraged SQLDelight for local offline persistence and Ktor for resilient network sync"
        ),
        githubUrl = "https://github.com/iqbalwork/talangraga-umroh-mobile",
        url = "https://github.com/iqbalwork/talangraga-umroh-mobile"
    ),
    Project(
        title = "PSC 119 & Buku Dokter",
        category = "Healthcare & Emergency",
        image = Res.drawable.compose_multiplatform,
        overview = "Engineered healthcare and emergency response applications from scratch at PT Jasamedika Saranatama, connecting ambulance drivers with hospital emergency response teams in real time.",
        techStack = listOf(
            "Kotlin & Java",
            "Mapbox Navigation SDK",
            "Multi-Module Architecture",
            "Koin Dependency Injection",
            "Real-time GPS Tracking"
        ),
        impact = listOf(
            "Emergency Response: Enabled real-time turn-by-turn navigation for ambulance drivers during emergency dispatches",
            "From Scratch Delivery: Built the Buku Dokter and PSC 119 application suite with modular, testable architecture",
            "Modernization: Migrated legacy hospital Java codebases to Kotlin"
        )
    ),
    Project(
        title = "Internal HRIS (Kinest / Kakatu)",
        category = "Enterprise Tools",
        image = Res.drawable.compose_multiplatform,
        overview = "Developed an internal Human Resource Information System Android application implementing modular design, dependency injection, and RESTful API integration via Retrofit.",
        techStack = listOf(
            "Android SDK",
            "Retrofit",
            "Dependency Injection",
            "Modular Architecture"
        ),
        impact = listOf(
            "Streamlined Operations: Delivered internal attendance and HR management tools for company operations",
            "Established Best Practices: Introduced clean architectural patterns and structured API client layers"
        )
    )
)

val educationInfo = EducationItem(
    degree = "Bachelor of Informatics Engineering",
    institution = "Universitas Siliwangi",
    location = "Tasikmalaya, Indonesia",
    period = "Sep 2014 – Aug 2018",
    description = "Focused on Software Engineering, Mobile Development, Algorithm Design, and Distributed Systems."
)

val socialMediaList = listOf(
    SocialData("LinkedIn", Res.drawable.linkedIn, "https://www.linkedin.com/in/ifauzii/"),
    SocialData("GitHub", Res.drawable.githublogo, "https://github.com/iqbalwork"),
    SocialData("WhatsApp", Res.drawable.wa, "https://wa.me/6287822882668"),
    SocialData("Instagram", Res.drawable.instagram, "https://www.instagram.com/uziro.id/"),
    SocialData("Threads", Res.drawable.threads, "https://www.threads.com/@uziro.id"),
    SocialData("Tiktok", Res.drawable.tiktok, "https://www.tiktok.com/@uziro.id"),
    SocialData("Youtube", Res.drawable.youtube, "https://www.youtube.com/@uziroid")
)
