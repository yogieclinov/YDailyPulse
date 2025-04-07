package com.clinov.ydailypulse.domain.model

import com.clinov.ydailypulse.data.model.BaseResponse
import io.ktor.client.network.sockets.ConnectTimeoutException

fun <T> BaseResponse.getResult(data: T): BaseResult<T> {
    return when {
        this.isAuthError() -> BaseResult.Error(ERROR_UNAUTHORIZED)
        this.isSuccess() -> BaseResult.Success(data)
        else -> BaseResult.Error(ERROR_GENERAL)
    }
}

fun Exception.getErrorResult(): BaseResult.Error {
    val code = when(this) {
        is ConnectTimeoutException -> ERROR_TIMEOUT
        else -> ERROR_GENERAL
    }
    return BaseResult.Error(code)
}

const val ERROR_GENERAL = 400
const val ERROR_UNAUTHORIZED = 401
const val ERROR_TIMEOUT = 599
