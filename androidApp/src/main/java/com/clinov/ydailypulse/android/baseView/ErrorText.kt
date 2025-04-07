package com.clinov.ydailypulse.android.baseView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinov.ydailypulse.presentation.ArticlesPresenter
import com.clinov.ydailypulse.presentation.model.ErrorUi


@Composable
fun ErrorText(message: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = message,
        style = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        ),
    )
}

@Composable
fun ErrorView(
    presenter: ArticlesPresenter,
    errorUi: ErrorUi
) {
    if (errorUi.getDesc().isNotBlank()) {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ErrorText(errorUi.getDesc())
                val buttonText = errorUi.getButtonText()
                if (buttonText.isNotBlank()) {
                    Button(
                        modifier = Modifier.padding(20.dp),
                        onClick = { presenter.onClickErrorUiButton(errorUi) }
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                            text = buttonText,
                            fontSize = 24.sp,
                        )
                    }
                }
            }
        }
    }
}