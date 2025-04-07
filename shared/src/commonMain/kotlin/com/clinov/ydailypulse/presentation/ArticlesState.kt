package com.clinov.ydailypulse.presentation

import com.clinov.ydailypulse.domain.model.Article
import com.clinov.ydailypulse.presentation.model.ErrorUi

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUi? = null,
)
