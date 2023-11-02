package ru.tour_base.feature_main.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import ru.tour_base.core_ui.theme.components.header
import ru.tour_base.data_main.domain.entity.blog.BlogElement
import ru.tour_base.data_main.domain.entity.main.MainContent

@Composable
internal fun MainScreenContent(
    modifier: Modifier = Modifier,
    gridState: LazyGridState,
    mainContent: MainContent?,
    blogElements: ImmutableList<BlogElement>?,
    onBlogElementClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
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
                    blogSubtitle = item.subtitle,
                    onClick = remember {
                        {
                            onBlogElementClick(item.id)
                        }
                    }
                )
            }
        }
    }
}