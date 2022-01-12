package com.example.busschedule.util

import android.annotation.SuppressLint
import com.example.busschedule.database.Schedule
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("h:mm a")

    fun getFormat(arrivalTime: String): String {
        return formatter.format(Date(arrivalTime.toLong() * 1000))
    }
}