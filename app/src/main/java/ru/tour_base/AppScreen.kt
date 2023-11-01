package ru.tour_base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.tour_base.core_navigation.MainNavScreen
import ru.tour_base.core_ui.theme.AppTheme
import ru.tour_base.feature_main.addMain

@Composable
fun AppScreen() {

    val navController = rememberNavController()
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }

    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = MainNavScreen.Root.route
            ) {
                addMain(viewModelStoreOwner)
            }
        }
    }
}