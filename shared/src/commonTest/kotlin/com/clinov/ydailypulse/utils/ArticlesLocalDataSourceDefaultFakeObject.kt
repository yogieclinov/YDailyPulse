package com.clinov.ydailypulse.utils

import com.clinov.ydailypulse.data.datasource.ArticlesLocalDataSource
import com.clinov.ydailypulse.data.model.ArticleDbEntity

class ArticlesLocalDataSourceDefaultFakeObject : ArticlesLocalDataSource {
    private val articles = mutableListOf<ArticleDbEntity>()

    override fun getHeadlineArticlesDb(): List<ArticleDbEntity> = articles

    override fun insertHeadlineArticlesDb(articles: List<ArticleDbEntity>) {
        this.articles.addAll(articles)
    }

    override fun clearHeadlineArticlesDb() {
        this.articles.clear()
    }
}