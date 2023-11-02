package ru.tour_base.feature_blog.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.squareup.picasso3.Picasso
import com.squareup.picasso3.compose.rememberPainter
import dev.jeziellago.compose.markdowntext.MarkdownText
import ru.tour_base.core.toDate
import ru.tour_base.core.toHumanString
import ru.tour_base.data_main.domain.entity.blog.BlogEntry
import ru.tour_base.feature_blog.model.BlogEntryScreenViewModel

@Composable
fun BlogEntryScreen(
    vm: BlogEntryScreenViewModel,
    navHostController: NavHostController,
    blogId: Int?
) {

    val listState = rememberLazyListState()
    val blogEntry = vm.blogEntry

    LaunchedEffect(blogId) {
        vm.getBlogEntry(blogId)
    }

    BackHandler(
        enabled = blogEntry != null
    ) {
        navHostController.popBackStack()
        vm.onNavigateBack()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        blogEntry?.let { entry ->
            BlogScreenContent(
                listState = listState,
                blogEntry = entry
            )
        }

        BlogBackButton(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 44.dp, start = 20.dp),
            onClick = remember {
                {
                    navHostController.popBackStack()
                    vm.onNavigateBack()
                }
            }
        )
    }
}

@Composable
private fun BlogScreenContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    blogEntry: BlogEntry?
) {
    val context = LocalContext.current

    blogEntry?.let { entry ->
        LazyColumn(
            modifier = modifier,
            state = listState
        ) {
            item(entry.imageList.lg) {
                val picasso = Picasso.Builder(context).build()

                val painter = picasso.rememberPainter(key = entry.imageList.lg) {
                    it.load(entry.imageList.lg)
                }

                Image(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit,
                    painter = painter,
                    contentDescription = null
                )
            }

            item(entry.date) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = entry.date.toDate()?.toHumanString() ?: "",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            item(entry.title) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    text = entry.title,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            item {
                Divider(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                )
            }

            item(entry.subtitle) {
                MarkdownText(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    markdown = entry.subtitle,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            item(entry.content) {
                MarkdownText(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    markdown = entry.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    linkColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
private fun BlogBackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clip(CircleShape)
            .height(IntrinsicSize.Min)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                enabled = true,
                onClick = onClick
            ),
        color = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            modifier = Modifier.padding(10.dp),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}