package com.pgz.consultoriopgz.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pgz.consultoriopgz.data.dao.ClientDao
import com.pgz.consultoriopgz.data.dao.ScheduleAppointmentDao
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

@Database(entities = [ClientEntity::class, ScheduleAppointmentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun scheduleAppointmentDao(): ScheduleAppointmentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pgz-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}