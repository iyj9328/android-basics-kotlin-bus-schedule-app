package com.example.busschedule.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Schedule(
    @PrimaryKey
    private val id : Int,

    @NonNull @ColumnInfo(name = "station_name")
    private val stationName : String,

    @NonNull @ColumnInfo(name = "arrival_time")
    private val arrivalTime : String
)