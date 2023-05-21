package com.pgz.consultoriopgz.modules.schedule.model

import com.pgz.consultoriopgz.modules.client.model.ClientModel
import java.util.Date

data class ScheduleAppointmentModel(
    var client:ClientModel,
    var doctor:String,
    var date: Date,
    var time:String
)
