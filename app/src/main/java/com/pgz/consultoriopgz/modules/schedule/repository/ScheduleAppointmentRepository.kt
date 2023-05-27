package com.pgz.consultoriopgz.modules.schedule.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

class ScheduleAppointmentRepository {

    suspend fun insertSchedule(scheduleSave: ScheduleAppointmentEntity) {
        ConsultorioPGZAPP.database.scheduleAppointmentDao().insertAppointment(scheduleSave)
    }

}