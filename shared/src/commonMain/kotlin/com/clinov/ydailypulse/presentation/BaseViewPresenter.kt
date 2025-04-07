package com.clinov.ydailypulse.presentation

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewPresenter() {

    val scope: CoroutineScope
}