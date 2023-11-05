package ru.tour_base.core

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.toDate(): Date? {
    val format = SimpleDateFormat("yyyy-MM-DD'T'hh:mm:ss", Locale.getDefault())

    return format.parse(this)
}

fun Date.toHumanString(): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.time = this

    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var month = calendar.get(Calendar.MONTH)
    val year = calendar.get(Calendar.YEAR)

    month++

    return "${if (day < 10) "0$day" else "$day" }.${if (month < 10) "0$month" else "$month" }.${year}"
}