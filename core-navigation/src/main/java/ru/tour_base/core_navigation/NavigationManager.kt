package ru.tour_base.core_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {
    private val commands = MutableStateFlow<BaseNav?>(null)

    fun navigate(command: BaseNav) {
        commands.value = command
    }
    fun back() {
        commands.value = NavigationBack()
    }

    private fun setNull() {
        commands.value = null
    }

    @Composable
    fun run(navHostController: NavHostController) {
        val navCommand by commands.collectAsState()

        LaunchedEffect(key1 = navCommand) {
            navCommand?.navigate(navHostController)
            setNull()
        }
    }
}