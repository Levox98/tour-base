package ru.tour_base.data_main.network.entity.main

import ru.tour_base.core_network.ApiResponse
import ru.tour_base.core_network.ErrorApiEntity

data class MainContentApiEntity(
    val data: MainContentDataApiEntity,
    override val error: ErrorApiEntity?,
    override val success: Boolean,
    override val time: String
) : ApiResponse