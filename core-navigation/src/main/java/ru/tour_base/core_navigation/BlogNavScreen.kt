package ru.tour_base.core_navigation

sealed class BlogNavScreen {
    abstract val route: String

    data object Root : BlogNavScreen() {
        override val route: String
            get() = "BlogRoot"
    }

    data object Blog : BlogNavScreen() {
        override val route: String
            get() = "Blog/{$BLOG_ID}"

        fun routeToBlog(blogId: Int) = "Blog/$blogId"

        const val BLOG_ID = "BLOG_ID"
    }
}