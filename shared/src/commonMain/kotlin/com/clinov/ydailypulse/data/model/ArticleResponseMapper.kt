package com.clinov.ydailypulse.data.model

import com.clinov.ydailypulse.domain.model.Article

fun ArticleResponse.toModel(): Article =
    Article(
        title = this.title.orEmpty(),
        desc = this.description.orEmpty(),
        date = this.publishedAt.orEmpty(),
        imageUrl = this.urlToImage.orEmpty(),
        sourceUrl = this.url.orEmpty(),
    )

fun Article.toDbEntity() = ArticleDbEntity(
    title = this.title,
    desc = this.desc,
    date = this.date,
    imageUrl = this.imageUrl,
    sourceUrl = this.sourceUrl,
)
