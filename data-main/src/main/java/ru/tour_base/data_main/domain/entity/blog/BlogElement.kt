package ru.tour_base.data_main.domain.entity.blog

data class BlogElement(
    val id: Int,
    val image: BlogImage,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: String
)
