package ru.tour_base.core_network

import java.util.Date

interface ApiResponse {
    val success: Boolean
    val error: ErrorApiEntity?
    val time: Date
}