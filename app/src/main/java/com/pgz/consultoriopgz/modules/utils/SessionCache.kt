package com.pgz.consultoriopgz.modules.utils

import com.pgz.consultoriopgz.modules.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.modules.schedule.model.ScheduleAppointmentModel

class SessionCache {
    companion object{
        var listClients:ArrayList<ClientModel> = ArrayList()
        var listSchedules:ArrayList<ScheduleAppointmentModel> = ArrayList()
    }
}