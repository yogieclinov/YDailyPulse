package com.clinov.ydailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.clinov.ydailypulse.data.DatabaseDriverFactory
import com.clinov.ydailypulse.db.YDailyPulseDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<YDailyPulseDatabase> { YDailyPulseDatabase(get()) }
}
