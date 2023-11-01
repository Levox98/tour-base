package ru.tour_base.data_main.network

import ru.tour_base.core.Either
import ru.tour_base.core_network.BaseApi
import ru.tour_base.data_main.network.entity.blog.BlogEntryApiEntity
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

    suspend fun getBlogEntry(entryUrl: String): Either<BlogEntryApiEntity> =
        doRequest(
            tag = "GET_BLOG_ENTRY",
            request = { mainApiService.getBlogContent(entryUrl) },
            mapper = { it }
        )
}