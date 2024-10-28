package com.clinov.ydailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform