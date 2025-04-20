package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticlesResponse

interface ArticleRemoteDataSource {

    suspend fun fetchHeadlineArticlesRemote(): ArticlesResponse
}