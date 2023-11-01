package ru.tour_base.data_main.network

import ru.tour_base.core.Either
import ru.tour_base.core_network.BaseApi
import ru.tour_base.data_main.network.entity.blog.BlogContentBlockApiEntity
import ru.tour_base.data_main.network.entity.main.MainContentApiEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainApi @Inject constructor(
    private val mainApiService: MainApiService
) : BaseApi() {

    suspend fun getMainContent(): Either<MainContentApiEntity> =
        doRequest(
            tag = "GET_MAIN_CONTENT",
            request = { mainApiService.getMainContent() },
            mapper = { it }
        )

    suspend fun getBlogContent(contentUrl: String): Either<BlogContentBlockApiEntity> =
        doRequest(
            tag = "GET_BLOG_ENTRY",
            request = { mainApiService.getBlogContent(contentUrl) },
            mapper = { it }
        )
}