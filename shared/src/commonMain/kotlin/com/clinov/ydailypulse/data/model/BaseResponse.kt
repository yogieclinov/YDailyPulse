package com.clinov.ydailypulse.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse {

    @SerialName("status") var status: String? = null
    @SerialName("code") val code: String? = null

    fun isSuccess() = status.equals(STRING_OK, ignoreCase = true)
    fun isAuthError() = code.equals(STRING_AUTH_ERROR, ignoreCase = true)

    companion object {
        const val STRING_OK = "ok"
        const val STRING_AUTH_ERROR = "apiKeyInvalid"
    }
}
