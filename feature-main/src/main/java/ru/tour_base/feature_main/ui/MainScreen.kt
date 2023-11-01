package ru.tour_base.feature_main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.tour_base.feature_main.model.MainScreenViewModel

@Composable
fun MainScreen(vm: MainScreenViewModel) {

    val mainContent by vm.mainContent.collectAsState(initial = null)
    val blogElements by vm.blogElements.collectAsState(initial = null)

    val listState = rememberLazyListState()

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
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                state = listState,
            ) {

                blogElements?.let { list ->
                    itemsIndexed(
                        items = list,
                        key = { _, item -> item.id }
                    ) { _, item ->
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(text = item.title)
                        }
                    }
                }
            }
        }
    }
}