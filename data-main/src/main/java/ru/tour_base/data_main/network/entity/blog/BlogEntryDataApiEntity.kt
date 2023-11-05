package ru.tour_base.data_main.network.entity.blog

data class BlogEntryDataApiEntity(
    val id: Int,
    val date: String,
    val url: String,
    val title: String,
    val subtitle: String,
    val image: BlogImageApiEntity,
    val content: String
)