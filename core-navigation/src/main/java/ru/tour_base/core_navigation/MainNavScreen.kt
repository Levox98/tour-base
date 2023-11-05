package ru.tour_base.core_navigation

sealed class MainNavScreen : BaseNav() {

    data object Root : MainNavScreen() {
        override val route: String
            get() = "MainRoot"
    }

    data object Main : MainNavScreen() {
        override val route: String
            get() = "MainScreen"
    }
}