package ru.tour_base.feature_main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.collections.immutable.toImmutableList
import ru.tour_base.core_navigation.BlogNavScreen
import ru.tour_base.core_ui.R
import ru.tour_base.core_ui.theme.Blue
import ru.tour_base.feature_main.model.MainScreenViewModel
import ru.tour_base.feature_main.ui.components.BottomNavItem
import ru.tour_base.feature_main.ui.components.MainScreenContent

@Composable
fun MainScreen(vm: MainScreenViewModel, navHostController: NavHostController) {

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
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            bottomBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(top = 10.dp, bottom = 8.dp),
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
        ) { paddingValues ->

            MainScreenContent(
                modifier = Modifier.padding(paddingValues),
                gridState = gridState,
                mainContent = mainContent,
                blogElements = blogElements?.toImmutableList(),
                onBlogElementClick = remember {
                    {
                        navHostController.navigate(BlogNavScreen.Blog.routeToBlog(it))
                    }
                }
            )
        }
    }
}
