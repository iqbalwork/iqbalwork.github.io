package com.uziro.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform