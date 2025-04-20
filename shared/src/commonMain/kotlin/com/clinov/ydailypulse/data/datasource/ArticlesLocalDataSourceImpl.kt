package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticleDbEntity
import com.clinov.ydailypulse.db.YDailyPulseDatabase

class ArticlesLocalDataSourceImpl(
    private val database: YDailyPulseDatabase
) : ArticlesLocalDataSource {

    override fun getHeadlineArticlesDb(): List<ArticleDbEntity> =
        database.ydailypulsedbQueries.selectAllArticles(::mapToArticleDbEntity).executeAsList()

    override fun insertHeadlineArticlesDb(articles: List<ArticleDbEntity>) {
        database.ydailypulsedbQueries.transaction {
            articles.forEach { insertArticle(it) }
        }
    }

    private fun insertArticle(article: ArticleDbEntity) {
        database.ydailypulsedbQueries.insertArticle(
            title = article.title,
            desc = article.desc,
            date = article.date,
            imageUrl = article.imageUrl,
            sourceUrl = article.sourceUrl
        )
    }

    override fun clearHeadlineArticlesDb() {
        database.ydailypulsedbQueries.removeAllArticles()
    }

    private fun mapToArticleDbEntity(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?,
        sourceUrl: String,
    ) = ArticleDbEntity(
        title = title,
        desc = desc,
        date = date,
        imageUrl = imageUrl,
        sourceUrl = sourceUrl,
    )
}