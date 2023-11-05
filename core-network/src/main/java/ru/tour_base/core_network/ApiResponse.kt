package ru.tour_base.core_network

interface ApiResponse {
    val success: Boolean
    val error: ErrorApiEntity?
    val time: String
}