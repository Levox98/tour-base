package ru.tour_base.data_main.network.entity.blog

import ru.tour_base.data_main.network.entity.DateApiEntity

data class BlogElementApiEntity(
    val id: Int,
    val image: BlogImageApiEntity,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: DateApiEntity
)
