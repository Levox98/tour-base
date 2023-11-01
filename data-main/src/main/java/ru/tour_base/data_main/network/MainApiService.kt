package ru.tour_base.data_main.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
import ru.tour_base.data_main.network.entity.blog.BlogEntryApiEntity
import ru.tour_base.data_main.network.entity.main.MainContentApiEntity

interface MainApiService {

    @GET("main?id=117")
    suspend fun getMainContent(): Response<MainContentApiEntity>

    @GET
    suspend fun getBlogContent(@Url contentUrl: String): Response<BlogEntryApiEntity>
}