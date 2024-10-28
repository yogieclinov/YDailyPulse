package com.clinov.ydailypulse

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        platform.logSystemInfo()
        return "Hello, ${platform.osName}!"
    }
}