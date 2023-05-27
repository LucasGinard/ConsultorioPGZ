package com.pgz.consultoriopgz.modules.schedule.model

import com.pgz.consultoriopgz.data.entitys.ClientEntity

data class ScheduleAppointmentModel(
    var client: ClientEntity?,
    var nameMedicine:String?,
    var date: String?,
    var time:String?,
    var amountCost:String?,
    var daysSelected: DaysSelectedModel?
)
