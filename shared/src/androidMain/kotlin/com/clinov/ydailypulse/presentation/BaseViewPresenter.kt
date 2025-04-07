package com.clinov.ydailypulse.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewPresenter: ViewModel() {

    actual val scope: CoroutineScope = viewModelScope
}