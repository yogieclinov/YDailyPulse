package com.clinov.ydailypulse.android.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toDateFormat(fromFormat: String = "yyyy-MM-dd", toFormat: String = "dd MMM yyyy"): String {
    return this.toDate(fromFormat)?.toDateString(toFormat).orEmpty()
}

fun String.toDate(format: String = "yyyy-MM-dd"): Date? {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    var date: Date? = null
    try {
        date = formatter.parse(this)
    } catch (e: Exception) {
        // no-op
    }
    return date
}

fun Date.toDateString(format: String = "d MMM yy"): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    var output = ""
    try {
        output = formatter.format(this)
    } catch (e: Exception) {
        // no-op
    }
    return output
}