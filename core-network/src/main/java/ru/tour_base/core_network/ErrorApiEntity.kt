package ru.tour_base.core_network

data class ErrorApiEntity(
    val name: String,
    val status: String,
    val code: String,
    val message: String
)
