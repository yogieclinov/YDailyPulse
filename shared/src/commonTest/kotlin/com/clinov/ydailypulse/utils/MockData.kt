package com.clinov.ydailypulse.utils

import com.clinov.ydailypulse.data.model.ArticleResponse

fun getArticleList() = listOf(
    ArticleResponse(
        author = "Mr A",
        title = "Title about economy",
        description = "Description about economy",
        url = "www.news.com/eco",
        urlToImage = "www.randomimg.com/economy.png",
        publishedAt = "2025-05-30T18:43:00.123456789+03:00",
        content = "Content about economy"
    ),
    ArticleResponse(
        author = "Mr B",
        title = "Title about education",
        description = "Description about education",
        url = "www.news.com/edu",
        urlToImage = "www.randomimg.com/education.png",
        publishedAt = "2025-05-30T19:43:00.123456789+03:00",
        content = "Content about education"
    )
)