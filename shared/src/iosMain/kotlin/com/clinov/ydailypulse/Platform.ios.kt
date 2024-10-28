package com.clinov.ydailypulse

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

class IOSPlatform: Platform {
    override val osName = UIDevice.currentDevice.systemName

    override val osVersion = UIDevice.currentDevice.systemVersion

    override val deviceModel = UIDevice.currentDevice.model

    override val density = UIScreen.mainScreen.scale.toInt()

    override fun logSystemInfo() {
        NSLog("$osName, $osVersion, $deviceModel, $density")
    }

}

actual fun getPlatform(): Platform = IOSPlatform()