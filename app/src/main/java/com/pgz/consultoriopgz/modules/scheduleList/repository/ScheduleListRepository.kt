package com.pgz.consultoriopgz.modules.scheduleList.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

class ScheduleListRepository {

    suspend fun deleteSchedule(scheduleEntity: ScheduleAppointmentEntity){
        ConsultorioPGZAPP.database.scheduleAppointmentDao().deleteAppointment(scheduleEntity)
    }

}