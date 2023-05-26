package com.pgz.consultoriopgz.utils

import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentModel

class SessionCache {
    companion object{
        var listClients:ArrayList<ClientModel> = ArrayList()
        var listSchedules:ArrayList<ScheduleAppointmentModel> = ArrayList()
    }
}