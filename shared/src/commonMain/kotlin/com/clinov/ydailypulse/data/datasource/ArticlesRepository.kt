package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticlesResponse

interface ArticlesRepository {
    suspend fun fetchHeadlineArticlesRemote(): ArticlesResponse
}
