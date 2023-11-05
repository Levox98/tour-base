package ru.tour_base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.tour_base.core_navigation.MainNavScreen
import ru.tour_base.core_navigation.NavigationManager
import ru.tour_base.core_ui.theme.AppTheme
import ru.tour_base.feature_blog.addBlog
import ru.tour_base.feature_main.addMain

@Composable
fun AppScreen(
    navigationManager: NavigationManager
) {
    val navHostController = rememberNavController()
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }

    navigationManager.run(navHostController)

    AppTheme(darkTheme = isSystemInDarkTheme()) {
        NavHost(
            navController = navHostController,
            startDestination = MainNavScreen.Root.route
        ) {
            addMain(viewModelStoreOwner)
            addBlog(viewModelStoreOwner)
        }
    }
}