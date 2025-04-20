package com.clinov.ydailypulse.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDbEntity(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val desc: String?,
    @SerialName("publishedAt")
    val date: String,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("sourceUrl")
    val sourceUrl: String,
)