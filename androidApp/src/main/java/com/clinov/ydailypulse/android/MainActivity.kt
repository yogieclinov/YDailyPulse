package com.clinov.ydailypulse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.clinov.ydailypulse.presentation.ArticlesPresenter

class MainActivity : ComponentActivity() {
    private val presenter: ArticlesPresenter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppScaffold(articlesPresenter = presenter)
                }
            }
        }
    }
}

// @Preview
// @Composable
// fun DefaultPreview() {
//    MyApplicationTheme {
//        DeviceInfoPage()
//    }
// }
