package com.clinov.ydailypulse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class BaseViewPresenter {

    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    fun clear() {
        scope.cancel()
    }
}