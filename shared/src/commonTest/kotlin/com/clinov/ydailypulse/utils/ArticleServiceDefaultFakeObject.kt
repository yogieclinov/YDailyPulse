package com.clinov.ydailypulse.utils

import com.clinov.ydailypulse.data.model.ArticlesResponse
import com.clinov.ydailypulse.data.service.ArticlesService

class ArticleServiceDefaultFakeObject : ArticlesService {

    override suspend fun fetchHeadlineArticles(): ArticlesResponse {
        return ArticlesResponse(
            totalResults = 2,
            articles = getArticleList(),
        ).also {
            it.status = "OK"
        }
    }
}