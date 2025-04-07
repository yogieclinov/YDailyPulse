package com.clinov.ydailypulse.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceResponse(
    @SerialName("id") var id: String? = null,
    @SerialName("name") var name: String? = null,
)
