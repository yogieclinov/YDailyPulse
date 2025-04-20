package com.clinov.ydailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.clinov.ydailypulse.data.DatabaseDriverFactory
import com.clinov.ydailypulse.db.YDailyPulseDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<YDailyPulseDatabase> { YDailyPulseDatabase(get()) }
}
