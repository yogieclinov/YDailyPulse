package com.clinov.ydailypulse.android.di

import com.clinov.ydailypulse.presentation.ArticlesPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModules = module {
    viewModel { ArticlesPresenter(get()) }
}
