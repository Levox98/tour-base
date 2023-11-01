package ru.tour_base.data_main.network.entity.blog

import ru.tour_base.core_network.ApiResponse
import ru.tour_base.core_network.ErrorApiEntity
import java.util.Date

data class BlogEntryApiEntity(
    override val success: Boolean,
    override val error: ErrorApiEntity?,
    override val time: Date,
    val data: BlogEntryDataApiEntity
) : ApiResponse
