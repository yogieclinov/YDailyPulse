package com.clinov.ydailypulse.domain

import com.clinov.ydailypulse.data.datasource.ArticlesRepository
import com.clinov.ydailypulse.data.model.toModel
import com.clinov.ydailypulse.domain.model.Article
import com.clinov.ydailypulse.domain.model.BaseResult
import com.clinov.ydailypulse.domain.model.getErrorResult
import com.clinov.ydailypulse.domain.model.getResult

class ArticlesUseCase(
    private val repository: ArticlesRepository,
) {

    suspend fun fetchHeadlineArticlesRemote(): BaseResult<List<Article>> {
        return try {
            val result = repository.fetchHeadlineArticlesRemote()
            val articles = result.articles.orEmpty().map { it.toModel() }
            result.getResult(articles)
        } catch (e: Exception) {
            e.getErrorResult()
        }
    }
}
