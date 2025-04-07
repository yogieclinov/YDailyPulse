package com.clinov.ydailypulse.presentation.model

import com.clinov.ydailypulse.domain.model.ERROR_UNAUTHORIZED

sealed class ErrorUi {

    abstract fun getDesc(): String
    abstract fun getButtonText(): String

    data class General(val data: Unit = Unit) : ErrorUi() {

        override fun getDesc(): String = "Error occurs. Try reload the page"
        override fun getButtonText(): String = "Reload"
    }

    data class Unauthorized(val data: Unit = Unit) : ErrorUi() {

        override fun getDesc(): String = "Unauthorized"
        override fun getButtonText(): String = ""
    }
}

fun Int.getErrorUi(): ErrorUi {
    return when (this) {
        ERROR_UNAUTHORIZED -> ErrorUi.Unauthorized()
        else -> ErrorUi.General()
    }
}
