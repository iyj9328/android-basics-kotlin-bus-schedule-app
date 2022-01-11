package com.example.busschedule.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll() : Flow<List<Schedule>>

    @Query("SELECT * FROM schedule WHERE station_name = :stationName ORDER BY arrival_time ASC")
    fun getByStationName(stationName: String): Flow<List<Schedule>>
}
