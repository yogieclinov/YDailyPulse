package com.clinov.ydailypulse.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.clinov.ydailypulse.db.YDailyPulseDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = YDailyPulseDatabase.Schema,
            context = context,
            name = "YDailyPulse.Database.db",
        )
    }
}