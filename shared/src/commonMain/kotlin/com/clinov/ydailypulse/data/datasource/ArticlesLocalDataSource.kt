package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticleDbEntity

interface ArticlesLocalDataSource {

    fun getHeadlineArticlesDb(): List<ArticleDbEntity>
    fun insertHeadlineArticlesDb(articles: List<ArticleDbEntity>)
    fun clearHeadlineArticlesDb()
}