package ru.tour_base.data_main.domain.entity.blog

import java.util.Date

data class BlogEntry(
    val id: Int,
    val date: Date,
    val url: String,
    val title: String,
    val subtitle: String,
    val imageList: BlogImage,
    val content: String
)
