package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.service.ArticlesService

class ArticleRemoteDataSourceImpl(
    private val service: ArticlesService,
) : ArticleRemoteDataSource {

    override suspend fun fetchHeadlineArticlesRemote() = service.fetchHeadlineArticles()
}