package com.clinov.ydailypulse.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("totalResults") var totalResults: Int? = null,
    @SerialName("articles") var articles: List<ArticleResponse>? = null,
) : BaseResponse()
