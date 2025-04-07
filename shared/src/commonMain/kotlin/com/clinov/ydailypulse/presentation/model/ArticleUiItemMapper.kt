package com.clinov.ydailypulse.presentation.model

import com.clinov.ydailypulse.domain.model.Article
import com.clinov.ydailypulse.utils.formatDateToString

fun Article.toUiItem() = ArticleUiItem(
    title = title,
    desc = desc,
    date = date.formatDateToString("dd MMM yyyy"),
    imageUrl = imageUrl,
    sourceUrl = sourceUrl
)