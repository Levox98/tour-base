package ru.tour_base.data_main.network.entity.blog

import java.util.Date

data class BlogEntryDataApiEntity(
    val id: Int,
    val date: Date,
    val url: String,
    val title: String,
    val subtitle: String,
    val image: BlogImageApiEntity,
    val content: String
)
