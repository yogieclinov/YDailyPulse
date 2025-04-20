package com.clinov.ydailypulse.data.datasource

import com.clinov.ydailypulse.data.model.ArticleDbEntity
import com.clinov.ydailypulse.db.YDailyPulseDatabase
import kotlinx.datetime.Clock

class ArticlesLocalDataSourceImpl(
    private val database: YDailyPulseDatabase
) : ArticlesLocalDataSource {

    private val cacheThreshold = 1000 * 60 * 60 // 60 minutes cache expired
    private val headlineArticlesTableName = "HeadlineArticle"

    private fun getCurrentTimeInMillis() = Clock.System.now().toEpochMilliseconds()

    override fun getHeadlineArticlesDb(): List<ArticleDbEntity> {
        val tableAccess = database.ydailypulsetablemanagerdbQueries.getTable(headlineArticlesTableName).executeAsOneOrNull()
        return if (isExpired(tableAccess?.lastUpdated)) {
            clearHeadlineArticlesDb()
            emptyList()
        } else {
            database.ydailypulsedbQueries.selectAllArticles(::mapToArticleDbEntity).executeAsList()
        }
    }

    private fun isExpired(lastUpdate: Long?): Boolean {
        if (lastUpdate == null) return true
        return getCurrentTimeInMillis() - lastUpdate > cacheThreshold
    }


    override fun insertHeadlineArticlesDb(articles: List<ArticleDbEntity>) {
        database.ydailypulsedbQueries.transaction {
            articles.forEach { insertArticle(it) }
            database.ydailypulsetablemanagerdbQueries.insertTableAccess(
                headlineArticlesTableName, getCurrentTimeInMillis()
            )
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