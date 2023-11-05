package ru.tour_base.core_navigation

import androidx.navigation.NavHostController

abstract class BaseNav {
    abstract val route: String

    open fun navigate(navController: NavHostController) {
        navController.navigate(route)
    }
}

class NavigationBack : BaseNav() {
    override val route: String = ""
    override fun navigate(navController: NavHostController) {
        navController.popBackStack()
    }
}