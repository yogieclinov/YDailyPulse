package com.clinov.ydailypulse.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.clinov.ydailypulse.db.YDailyPulseDatabase

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = YDailyPulseDatabase.Schema,
            name = "YDailyPulse.Database.db",
        )
    }
}