package com.pgz.consultoriopgz.modules.schedule.model

import android.content.Context
import java.util.Date

interface ScheduleAppointmentContract {
    interface View{
        fun setDateSelected(date:String)
    }

    interface Presenter{
        fun showDatePicker(context: Context)
    }
}