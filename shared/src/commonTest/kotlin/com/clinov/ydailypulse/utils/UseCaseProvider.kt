package com.clinov.ydailypulse.utils

import com.clinov.ydailypulse.data.datasource.ArticleRemoteDataSourceImpl
import com.clinov.ydailypulse.data.datasource.ArticlesRepositoryImpl
import com.clinov.ydailypulse.domain.ArticlesUseCase

fun provideArticlesUseCase() = ArticlesUseCase(
    provideArticlesRepository()
)

fun provideArticlesRepository() = ArticlesRepositoryImpl(
    remoteDataSource = provideArticleRemoteDataSource(),
    localDataSource = provideArticleLocalDataSource()
)

fun provideArticleRemoteDataSource() = ArticleRemoteDataSourceImpl(
    service = ArticleServiceDefaultFakeObject()
)

fun provideArticleLocalDataSource() = ArticlesLocalDataSourceDefaultFakeObject()