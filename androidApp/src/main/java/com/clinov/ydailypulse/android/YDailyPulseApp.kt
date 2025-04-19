package com.clinov.ydailypulse.android

import android.app.Application
import com.clinov.ydailypulse.android.di.presenterModules
import com.clinov.ydailypulse.di.sharedDiModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YDailyPulseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedDiModules + presenterModules
        startKoin {
            androidContext(this@YDailyPulseApp)
            modules(modules)
        }
    }
}