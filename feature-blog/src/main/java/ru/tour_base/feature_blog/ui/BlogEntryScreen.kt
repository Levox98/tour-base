package ru.tour_base.feature_blog.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.tour_base.feature_blog.model.BlogEntryScreenViewModel
import ru.tour_base.feature_blog.ui.components.BlogBackButton
import ru.tour_base.feature_blog.ui.components.BlogScreenContent

@Composable
fun BlogEntryScreen(
    vm: BlogEntryScreenViewModel,
    blogId: Int?
) {

    val listState = rememberLazyListState()
    val blogEntry = vm.blogEntry

    LaunchedEffect(blogId) {
        vm.getBlogEntry(blogId)
    }

    BackHandler(
        enabled = blogEntry != null,
        onBack = vm::onNavigateBack
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        blogEntry?.let { entry ->
            BlogScreenContent(
                listState = listState,
                blogEntry = entry
            )
        }

        BlogBackButton(
            modifier = Modifier
                .padding(top = 44.dp, start = 20.dp),
            onClick = vm::onNavigateBack
        )
    }
}
