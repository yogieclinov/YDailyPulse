package com.clinov.ydailypulse.android.articlesPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.clinov.ydailypulse.android.baseView.AppBar
import com.clinov.ydailypulse.android.baseView.ErrorText
import com.clinov.ydailypulse.android.baseView.Loader
import com.clinov.ydailypulse.android.util.toDateFormat
import com.clinov.ydailypulse.articles.ArticlesPresenter
import com.clinov.ydailypulse.articles.model.Article

@Composable
fun ArticlesPage(
    onClickNavIcon: () -> Unit,
    presenter: ArticlesPresenter
) {
    val state = presenter.articlesState.collectAsState()
    Column {
        AppBar(onClickNavIcon)
        if (state.value.isLoading) {
            Loader()
        }
        val errorMessage = state.value.errorMessage
        if (!errorMessage.isNullOrBlank()) {
            ErrorText(errorMessage)
        }
        val articles = state.value.articles
        if (articles.isNotEmpty()) {
            ArticlesList(articles)
        }
    }
}

@Composable
private fun ArticlesList(articles: List<Article>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(articles) {
            ArticleItem(article = it)
        }
    }
}

@Composable
private fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.imageUrl)
                .crossfade(true).build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 8.dp)),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date.toDateFormat(),
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}