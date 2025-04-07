package com.clinov.ydailypulse.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("source") var source: SourceResponse? = null,
    @SerialName("author") var author: String? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("urlToImage") var urlToImage: String? = null,
    @SerialName("publishedAt") var publishedAt: String? = null,
    @SerialName("content") var content: String? = null,
)
