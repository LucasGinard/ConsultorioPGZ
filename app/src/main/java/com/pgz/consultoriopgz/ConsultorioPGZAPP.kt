package com.pgz.consultoriopgz

import android.app.Application
import androidx.room.Room
import com.pgz.consultoriopgz.data.database.AppDatabase

class ConsultorioPGZAPP : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "pgz-database").build()
    }

}