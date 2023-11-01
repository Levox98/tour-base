package ru.tour_base.data_main.data.mappers

import ru.tour_base.data_main.domain.entity.blog.BlogElement
import ru.tour_base.data_main.domain.entity.blog.BlogEntry
import ru.tour_base.data_main.domain.entity.blog.BlogImage
import ru.tour_base.data_main.network.entity.blog.BlogElementApiEntity
import ru.tour_base.data_main.network.entity.blog.BlogEntryApiEntity
import ru.tour_base.data_main.network.entity.blog.BlogImageApiEntity

fun BlogEntryApiEntity.toDomain() = BlogEntry(
    id = data.id,
    date = data.date,
    url = data.url,
    title = data.title,
    subtitle = data.subtitle,
    imageList = data.image.toDomain(),
    content = data.content
)

private fun BlogImageApiEntity.toDomain() = BlogImage(sm, md, lg)

private fun BlogElementApiEntity.toDomain() = BlogElement(
    id = id,
    image = image.toDomain(),
    title = title,
    subtitle = subtitle,
    view = view,
    like = like,
    date = date.date
)

fun List<BlogElementApiEntity>.toDomain() = this.map { it.toDomain() }