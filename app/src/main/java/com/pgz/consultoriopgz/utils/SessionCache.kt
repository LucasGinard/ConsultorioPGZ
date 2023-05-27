package com.pgz.consultoriopgz.utils

import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentModel

class SessionCache {
    companion object{
        var listClients:ArrayList<ClientEntity> = ArrayList()
        var listSchedules:ArrayList<ScheduleAppointmentModel> = ArrayList()
    }
}