package ru.tour_base.feature_main

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.tour_base.core_navigation.MainNavScreen
import ru.tour_base.feature_main.ui.MainScreen

fun NavGraphBuilder.addMain(
    viewModelStoreOwner: ViewModelStoreOwner
) {
    navigation(
        startDestination = MainNavScreen.Main.route,
        route = MainNavScreen.Root.route
    ) {
        composable(
            route = MainNavScreen.Main.route
        ) {
            MainScreen(
                vm = hiltViewModel(viewModelStoreOwner)
            )
        }
    }
}