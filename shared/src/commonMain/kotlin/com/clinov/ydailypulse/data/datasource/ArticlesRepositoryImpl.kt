package com.clinov.ydailypulse.data.datasource

class ArticlesRepositoryImpl(
    private val remoteDataSource: ArticleRemoteDataSource,
    private val localDataSource: ArticlesLocalDataSource
) : ArticlesRepository,
    ArticleRemoteDataSource by remoteDataSource,
    ArticlesLocalDataSource by localDataSource
