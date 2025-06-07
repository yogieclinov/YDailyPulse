package com.clinov.ydailypulse
import com.clinov.ydailypulse.data.model.toModel
import com.clinov.ydailypulse.presentation.ArticlesPresenter
import com.clinov.ydailypulse.presentation.model.ArticleUiItem
import com.clinov.ydailypulse.utils.getArticleList
import com.clinov.ydailypulse.utils.provideArticlesUseCase
import com.clinov.ydailypulse.utils.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class ArticlesPresenterTest {

    private lateinit var presenter: ArticlesPresenter

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        presenter = ArticlesPresenter(provideArticlesUseCase())
    }

    @Test
    fun `test init page when success fetch articles should set valid state`() = runTest {
        val expectedArticles = getArticleList().map { it.toModel() }
        presenter.articlesState.value.articles shouldBe expectedArticles
        presenter.articlesState.value.isLoading shouldBe false
        presenter.articlesState.value.error shouldBe null
    }

    @Test
    fun `test init page when success fetch articles should give valid ui models`() = runTest {
        presenter.articlesState.value.uiModels shouldBe listOf(
            ArticleUiItem(
                title = "Title about economy",
                desc = "Description about economy",
                date = "30 May 2025",
                imageUrl = "www.randomimg.com/economy.png",
                sourceUrl = "www.news.com/eco"
            ),
            ArticleUiItem(
                title = "Title about education",
                desc = "Description about education",
                date = "30 May 2025",
                imageUrl = "www.randomimg.com/education.png",
                sourceUrl = "www.news.com/edu"
            )
        )
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
