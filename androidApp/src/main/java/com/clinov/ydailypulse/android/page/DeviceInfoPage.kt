package com.clinov.ydailypulse.android.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clinov.ydailypulse.android.Toolbar
import com.clinov.ydailypulse.getPlatform

@Composable
fun DeviceInfoPage() {
    Column {
        Toolbar()
        ContentView()
    }
}


@Composable
private fun ContentView() {
    val uiItems = makeUiItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(uiItems) { idx, item ->
            RowView(title = item.first, subtitle = item.second, idx = idx, totalItems = uiItems.size)
        }
    }
}

private fun makeUiItems(): List<Pair<String, String>> {
    val platform = getPlatform()
    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
private fun RowView(title: String, subtitle: String, idx: Int, totalItems: Int) {
    Row(
        modifier = Modifier.fillMaxSize().padding(
            start = 8.dp,
            top = if (idx == 0) 8.dp else 4.dp,
            end = 8.dp,
            bottom = if (idx == totalItems - 1) 8.dp else 4.dp
        )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.38f),
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Text(
            modifier = Modifier.fillMaxWidth(1f),
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}