package ru.tour_base.data_main.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import ru.tour_base.data_main.network.entity.blog.BlogContentBlockApiEntity
import ru.tour_base.data_main.network.entity.blog.BlogEntryApiEntity
import ru.tour_base.data_main.network.entity.main.MainContentApiEntity

interface MainApiService {

    //Get main screen content
    @GET("main")
    suspend fun getMainContent(@Query("id") id: Int = 117): Response<MainContentApiEntity>

    //Get blog content block for main screen
    @GET
    suspend fun getBlogContent(@Url contentUrl: String): Response<BlogContentBlockApiEntity>

    //Get specific blog entry by 'blogId'
    @GET("blog-info")
    suspend fun geBlogEntry(
        @Query("id") id: Int = 117,
        @Query("blog_id") blogId: Int
    ): Response<BlogEntryApiEntity>
}