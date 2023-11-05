package ru.tour_base.data_main.network.entity.blog

import ru.tour_base.core_network.ApiResponse
import ru.tour_base.core_network.ErrorApiEntity

data class BlogContentBlockApiEntity(
    override val success: Boolean,
    override val error: ErrorApiEntity?,
    override val time: String,
    val data: List<BlogElementApiEntity>
) : ApiResponse
