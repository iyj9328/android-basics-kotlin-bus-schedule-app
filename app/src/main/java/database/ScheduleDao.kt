package database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll() : List<Schedule>

    @Query("SELECT * FROM schedule WHERE station_name = :stationName ORDER BY arrival_time ASC")
    fun getByStationName(stationName: String): List<Schedule>
}
