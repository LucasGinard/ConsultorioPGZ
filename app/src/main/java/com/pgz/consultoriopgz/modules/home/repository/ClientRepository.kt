package com.pgz.consultoriopgz.modules.home.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity
import kotlinx.coroutines.GlobalScope

class MainRepository {

    suspend fun getClientes():ArrayList<ClientEntity> {
        return ConsultorioPGZAPP.database.clientDao().getAllClients() as ArrayList<ClientEntity>
    }

    suspend fun getSchedules():ArrayList<ScheduleAppointmentEntity> {
        return ConsultorioPGZAPP.database.scheduleAppointmentDao().getAllAppointments() as ArrayList<ScheduleAppointmentEntity>
    }

}