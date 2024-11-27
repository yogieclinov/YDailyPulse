package com.clinov.ydailypulse

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewPresenter() {

    val scope: CoroutineScope
}