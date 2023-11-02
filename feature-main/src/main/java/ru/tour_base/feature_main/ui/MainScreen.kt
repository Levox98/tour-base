package ru.tour_base.feature_main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.tour_base.feature_main.model.MainScreenViewModel
import ru.tour_base.feature_main.ui.components.BlogCard

@Composable
fun MainScreen(vm: MainScreenViewModel) {

    val mainContent by vm.mainContent.collectAsState(initial = null)
    val blogElements by vm.blogElements.collectAsState(initial = null)

    val gridState = rememberLazyGridState()

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                Row(
                    modifier = Modifier.fillMaxWidth().statusBarsPadding()
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "Главная",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        ) { paddingValues ->

            LazyVerticalGrid(
                modifier = Modifier.padding(paddingValues),
                state = gridState,
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {

                mainContent?.content?.firstOrNull { it.template.objectName == "blog" }?.let {
                    header {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                            text = it.title,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }

                blogElements?.let { list ->
                    itemsIndexed(
                        items = list,
                        key = { _, item -> item.id }
                    ) { index, item ->
                        BlogCard(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .then(
                                    when {
                                        index % 2 == 0 -> Modifier.padding(end = 4.dp)
                                        else -> Modifier.padding(start = 4.dp)
                                    }
                                ),
                            imageUrl = item.image.md,
                            blogTitle = item.title,
                            blogSubtitle = item.subtitle
                        )
                    }
                }
            }
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}