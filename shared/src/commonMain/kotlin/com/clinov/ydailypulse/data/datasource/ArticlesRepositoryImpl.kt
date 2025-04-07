package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticlesResponse
import com.clinov.ydailypulse.data.service.ArticlesService
import com.clinov.ydailypulse.data.service.ArticlesServiceImpl

class ArticlesRepositoryImpl(
    private val service: ArticlesService = ArticlesServiceImpl(),
) : ArticlesRepository {

    override suspend fun fetchHeadlineArticlesRemote(): ArticlesResponse =
        service.fetchHeadlineArticles()
}
