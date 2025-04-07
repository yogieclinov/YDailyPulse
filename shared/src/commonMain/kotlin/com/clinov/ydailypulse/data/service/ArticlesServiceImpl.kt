package com.clinov.ydailypulse.data.service

import com.clinov.ydailypulse.data.datasource.RestClient
import com.clinov.ydailypulse.data.model.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesServiceImpl(
    private val httpClient: HttpClient = RestClient.instance,
) : ArticlesService {
    private val country = "us"
    private val category = "business"
    private val apiKey = "b58d48e533c640faab7a58a12d74c86b"

    override suspend fun fetchHeadlineArticles(): ArticlesResponse {
        val response: ArticlesResponse =
            httpClient
                .get(
                    "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey",
                ).body()
        return response
    }
}
