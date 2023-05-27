package com.pgz.consultoriopgz.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

@Dao
interface ScheduleAppointmentDao {

    @Query("SELECT * FROM appointments")
    suspend fun getAllAppointments(): List<ScheduleAppointmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: ScheduleAppointmentEntity)

    @Delete
    suspend fun deleteAppointment(appointment: ScheduleAppointmentEntity)
}