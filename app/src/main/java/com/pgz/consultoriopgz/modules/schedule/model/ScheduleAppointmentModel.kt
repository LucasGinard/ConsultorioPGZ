package com.pgz.consultoriopgz.modules.schedule.model

import com.pgz.consultoriopgz.modules.client.model.ClientModel

data class ScheduleAppointmentModel(
    var client:ClientModel?,
    var doctor:String?,
    var date: String?,
    var time:String?
)
