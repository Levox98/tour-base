package ru.tour_base.core_navigation

sealed class BlogNavScreen : BaseNav() {

    data object Root : BlogNavScreen() {
        override val route: String
            get() = "BlogRoot"
    }

    class Blog(private val blogId: Int? = null) : BlogNavScreen() {
        override val route: String
            get() = "Blog/${blogId ?: "{$BLOG_ID}"}"

        companion object {
            const val BLOG_ID = "BLOG_ID"
        }
    }
}