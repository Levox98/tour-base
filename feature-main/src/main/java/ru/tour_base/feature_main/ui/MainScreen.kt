package ru.tour_base.feature_main.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.tour_base.feature_main.model.MainScreenViewModel

@Composable
fun MainScreen(vm: MainScreenViewModel) {

    val mainContent = vm.mainContent.collectAsState(initial = null)

    Text(text = mainContent.value?.buttons?.first()?.title ?: "Loading")
}