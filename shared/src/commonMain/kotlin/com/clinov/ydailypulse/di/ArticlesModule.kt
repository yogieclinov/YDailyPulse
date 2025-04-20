package com.clinov.ydailypulse.di

import com.clinov.ydailypulse.data.datasource.ArticleRemoteDataSource
import com.clinov.ydailypulse.data.datasource.ArticleRemoteDataSourceImpl
import com.clinov.ydailypulse.data.datasource.ArticlesLocalDataSource
import com.clinov.ydailypulse.data.datasource.ArticlesLocalDataSourceImpl
import com.clinov.ydailypulse.data.datasource.ArticlesRepository
import com.clinov.ydailypulse.data.datasource.ArticlesRepositoryImpl
import com.clinov.ydailypulse.data.service.ArticlesService
import com.clinov.ydailypulse.data.service.ArticlesServiceImpl
import com.clinov.ydailypulse.domain.ArticlesUseCase
import com.clinov.ydailypulse.presentation.ArticlesPresenter
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesServiceImpl(get()) }
    single<ArticleRemoteDataSource> { ArticleRemoteDataSourceImpl(get()) }
    single<ArticlesLocalDataSource> { ArticlesLocalDataSourceImpl(get()) }
    single<ArticlesRepository> { ArticlesRepositoryImpl(get(), get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesPresenter> { ArticlesPresenter(get()) }
}
