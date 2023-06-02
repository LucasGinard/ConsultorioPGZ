package com.pgz.consultoriopgz.utils

import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

class SessionCache {
    companion object{
        var listClients:ArrayList<ClientEntity> = ArrayList()
        var listSchedules:ArrayList<ScheduleAppointmentEntity> = ArrayList()
        var listCheckToDeleteSchedule:ArrayList<ScheduleAppointmentEntity> = ArrayList()
        var listCheckToDeleteClient:ArrayList<ClientEntity> = ArrayList()
    }
}