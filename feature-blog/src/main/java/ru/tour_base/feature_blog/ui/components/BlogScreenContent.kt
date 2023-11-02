package ru.tour_base.feature_blog.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.squareup.picasso3.Picasso
import com.squareup.picasso3.compose.rememberPainter
import dev.jeziellago.compose.markdowntext.MarkdownText
import ru.tour_base.core.toDate
import ru.tour_base.core.toHumanString
import ru.tour_base.data_main.domain.entity.blog.BlogEntry


@Composable
internal fun BlogScreenContent(
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
                        .navigationBarsPadding()
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