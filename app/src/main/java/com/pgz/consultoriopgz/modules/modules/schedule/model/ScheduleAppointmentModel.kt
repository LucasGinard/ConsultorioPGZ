package com.pgz.consultoriopgz.modules.modules.schedule.model

import com.pgz.consultoriopgz.modules.modules.client.model.ClientModel

data class ScheduleAppointmentModel(
    var client: ClientModel?,
    var nameMedicine:String?,
    var date: String?,
    var time:String?,
    var amountCost:String?,
    var daysSelected: DaysSelectedModel?
)
