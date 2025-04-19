package com.clinov.ydailypulse.android

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clinov.ydailypulse.android.articlesPage.ArticlesPage
import com.clinov.ydailypulse.android.deviceInfoPage.DeviceInfoPage
import com.clinov.ydailypulse.android.router.PageNav
import com.clinov.ydailypulse.presentation.ArticlesPresenter

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(it),
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = PageNav.ARTICLES.route,
        modifier = modifier,
        enterTransition = {
            slideIn(
                animationSpec = tween(200),
                initialOffset = { IntOffset(0, 10) },
            )
        },
        exitTransition = {
            slideOut(
                animationSpec = tween(200),
                targetOffset = { IntOffset(0, 10) },
            )
        },
    ) {
        composable(PageNav.ARTICLES.route) {
            ArticlesPage(
                onClickNavIcon = { navController.navigate(PageNav.ABOUT_DEVICE.route) },
            )
        }
        composable(PageNav.ABOUT_DEVICE.route) {
            DeviceInfoPage(
                onClickNavIcon = { navController.popBackStack() },
            )
        }
    }
}
