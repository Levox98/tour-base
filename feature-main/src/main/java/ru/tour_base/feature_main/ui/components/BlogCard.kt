package ru.tour_base.feature_main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.squareup.picasso3.Picasso
import com.squareup.picasso3.compose.rememberPainter

@Composable
internal fun BlogCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    blogTitle: String,
    blogSubtitle: String,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val picasso = Picasso.Builder(context).build()

    Surface(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                enabled = true,
                onClick = onClick
            )
    ) {
        Column {
            val painter = picasso.rememberPainter(key = imageUrl) {
                it.load(imageUrl)
            }

            Image(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small),
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