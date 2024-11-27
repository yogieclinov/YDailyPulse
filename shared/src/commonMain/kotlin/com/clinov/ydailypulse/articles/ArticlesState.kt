package com.clinov.ydailypulse.articles

import com.clinov.ydailypulse.articles.model.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)