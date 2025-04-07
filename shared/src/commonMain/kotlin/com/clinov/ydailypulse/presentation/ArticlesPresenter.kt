package com.clinov.ydailypulse.presentation

import com.clinov.ydailypulse.BaseViewPresenter
import com.clinov.ydailypulse.domain.ArticlesUseCase
import com.clinov.ydailypulse.domain.model.Article
import com.clinov.ydailypulse.domain.model.BaseResult
import com.clinov.ydailypulse.presentation.model.ErrorUi
import com.clinov.ydailypulse.presentation.model.getErrorUi
import com.clinov.ydailypulse.utils.asUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesPresenter(
    private val useCase: ArticlesUseCase = ArticlesUseCase(),
) : BaseViewPresenter() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        fetchArticles()
    }

    private fun fetchArticles() = scope.launch {
        _articlesState.emit(ArticlesState(isLoading = true))
        onRetrieveArticles(useCase.fetchHeadlineArticlesRemote())
    }.asUnit()

    private suspend fun onRetrieveArticles(result: BaseResult<List<Article>>) {
        when (result) {
            is BaseResult.Success -> _articlesState.emit(ArticlesState(result.data))
            is BaseResult.Error -> _articlesState.emit(ArticlesState(error = result.errorCode.getErrorUi()))
        }
    }

    fun onClickErrorUiButton(errorUi: ErrorUi) {
        onReloadPage()
    }

    private fun onReloadPage() = scope.launch {
        _articlesState.value = articlesState.value.copy(isLoading = true)
        onRetrieveArticles(useCase.fetchHeadlineArticlesRemote())
    }.asUnit()
}
