package com.clinov.ydailypulse.di

import com.clinov.ydailypulse.presentation.ArticlesPresenter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedDiModules
    startKoin {
        modules(modules)
    }
}

class ArticlesInjector: KoinComponent {
    val articlesPresenter: ArticlesPresenter by inject()
}
