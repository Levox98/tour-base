package ru.tour_base.feature_main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.squareup.picasso3.Picasso
import com.squareup.picasso3.compose.rememberPainter
import ru.tour_base.core_ui.theme.Gray

@Composable
internal fun BlogCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    blogTitle: String,
    blogSubtitle: String
) {
    val context = LocalContext.current

    Surface(
        modifier = modifier
    ) {
        val picasso = Picasso.Builder(context).build()
        val painter = picasso.rememberPainter(key = imageUrl) {
            it.load(imageUrl)
        }

        Column(
            modifier = Modifier,

            ) {
            Image(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .border(1.dp, Gray, MaterialTheme.shapes.small),
                painter = painter,
                contentDescription = null
            )

            Spacer(modifier = Modifier.requiredHeight(4.dp))

            Text(
                text = blogTitle,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.requiredHeight(2.dp))

            Text(
                text = blogSubtitle,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}