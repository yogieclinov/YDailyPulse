package com.clinov.ydailypulse.articles

import com.clinov.ydailypulse.BaseViewPresenter
import com.clinov.ydailypulse.articles.model.Article
import com.clinov.ydailypulse.utils.asUnit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesPresenter : BaseViewPresenter() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        fetchArticles()
    }

    private fun fetchArticles() = scope.launch {
        _articlesState.emit(ArticlesState(isLoading = true))
        delay(1000L)
        _articlesState.emit(ArticlesState(articles = mockArticles))
    }.asUnit()

    private val mockArticles = listOf(
        Article(
            title = "Article 1",
            desc = "asdfja; lsdjfa;lsdf ja;ldj fklaj ldfasd",
            date = "2024-11-14",
            imageUrl = "https://fastly.picsum.photos/id/605/400/200.jpg?hmac=3udpJwe-Im_ZNAXFwlmO5zHIOWxShtLKy1gzqEn6oI8"
        ),
        Article(
            title = "Article 2",
            desc = "lkajsldkf jhasd hflkajwehp0[asd fapd fa09e8wr",
            date = "2024-11-15",
            imageUrl = "https://fastly.picsum.photos/id/351/400/200.jpg?hmac=IJK1-Udfbbdk7ykgNA_0AclI8T-AoZ1cKWEeLMiEGJ4"
        ),
        Article(
            title = "Article 3",
            desc = " 2394 y2u3234kjwn rqkj3h 4k2j3qwkejhf piau3242342",
            date = "2024-11-16",
            imageUrl = "https://fastly.picsum.photos/id/568/400/200.jpg?hmac=HNbN1XqWUosg1XEfmXYtKH1oOW_ReZdtwIqkYMuwLA0"
        ),
        Article(
            title = "Article 4",
            desc = " 2394 lkajh efk rqkj3h 4k2j3qwkejhf 1213oihn",
            date = "2024-11-16",
            imageUrl = "https://fastly.picsum.photos/id/190/400/200.jpg?hmac=P-rBiaxl8VRkXRzsaRSvp_wzSuS6Ckq8-nOPRpoIf1M"
        )

    )
}