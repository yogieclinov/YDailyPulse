package com.clinov.ydailypulse.utils

import kotlinx.datetime.Instant


expect fun Instant.formatDate(pattern: String, defValue: String = ""): String

expect fun String.parseDate(pattern: String, defValue: Long = 0L): Long

fun String.formatDateToString(pattern: String, defValue: String = ""): String {
    return Instant.parse(this).formatDate(pattern, defValue)
}
