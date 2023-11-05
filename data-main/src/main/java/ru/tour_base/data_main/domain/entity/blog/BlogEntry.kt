package ru.tour_base.data_main.domain.entity.blog

data class BlogEntry(
    val id: Int,
    val date: String,
    val url: String,
    val title: String,
    val subtitle: String,
    val imageList: BlogImage,
    val content: String
)
