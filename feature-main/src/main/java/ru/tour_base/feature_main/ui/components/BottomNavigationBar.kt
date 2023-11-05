package ru.tour_base.feature_main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.tour_base.core_ui.R
import ru.tour_base.core_ui.theme.Blue

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNavItem(
            iconId = R.drawable.home,
            text = "Главная",
            tint = Blue
        )

        BottomNavItem(
            iconId = R.drawable.map_search_outline,
            text = "Карта"
        )

        BottomNavItem(
            iconId = R.drawable.shopping_outline,
            text = "Бронь"
        )

        BottomNavItem(
            iconId = R.drawable.comments,
            text = "Чат"
        )

        BottomNavItem(
            iconId = R.drawable.dots_horizontal,
            text = "Ещё"
        )
    }
}