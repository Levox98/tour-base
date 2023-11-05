package ru.tour_base.feature_blog

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ru.tour_base.core_navigation.BlogNavScreen
import ru.tour_base.feature_blog.ui.BlogEntryScreen

fun NavGraphBuilder.addBlog(
    viewModelStoreOwner: ViewModelStoreOwner
) {
    navigation(
        route = BlogNavScreen.Root.route,
        startDestination = BlogNavScreen.Blog().route
    ) {
        composable(
            route = BlogNavScreen.Blog().route,
            arguments = listOf(
                navArgument(BlogNavScreen.Blog.BLOG_ID) { NavType.IntType }
            )
        ) {
            val blogId = it.arguments?.getString(BlogNavScreen.Blog.BLOG_ID)

            BlogEntryScreen(
                vm = hiltViewModel(viewModelStoreOwner),
                blogId = blogId?.toInt()
            )
        }
    }
}