package com.clinov.ydailypulse.data.model

import com.clinov.ydailypulse.domain.model.Article

fun ArticleDbEntity.toModel() = Article(
    title = title,
    desc = desc.orEmpty(),
    date = date,
    imageUrl = imageUrl.orEmpty(),
    sourceUrl = sourceUrl
)