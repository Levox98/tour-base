package ru.tour_base.feature_main.ui

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toImmutableList
import ru.tour_base.feature_main.model.MainScreenViewModel
import ru.tour_base.feature_main.ui.components.BottomNavigationBar
import ru.tour_base.feature_main.ui.components.MainScreenContent

@Composable
fun MainScreen(vm: MainScreenViewModel) {

    val mainContent by vm.mainContent.collectAsState(initial = null)
    val blogElements = vm.blogElements

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
                BottomNavigationBar(
                    modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(top = 10.dp, bottom = 8.dp)
                )
            }
        ) { paddingValues ->

            MainScreenContent(
                modifier = Modifier.padding(paddingValues),
                gridState = gridState,
                mainContent = mainContent,
                blogElements = blogElements?.toImmutableList(),
                onBlogElementClick = vm::navigateToBlog
            )
        }
    }
}
