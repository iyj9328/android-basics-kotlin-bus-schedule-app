package com.example.busschedule

import android.app.Application
import com.example.busschedule.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}