package com.clinov.ydailypulse.data.service

import com.clinov.ydailypulse.data.model.ArticlesResponse

interface ArticlesService {
    suspend fun fetchHeadlineArticles(): ArticlesResponse
}
