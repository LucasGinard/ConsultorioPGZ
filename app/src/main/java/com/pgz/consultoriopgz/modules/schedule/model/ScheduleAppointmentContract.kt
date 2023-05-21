package com.pgz.consultoriopgz.modules.schedule.model

import android.content.Context
import java.util.Date

interface ScheduleAppointmentContract {
    interface View{
        fun setDateSelected(date:String)
        fun setTimeSelected(time:String)
        fun goHome()
    }

    interface Presenter{
        fun showDatePicker(context: Context)
        fun showTimePicker(context: Context)
        fun addNewScheduleAppointment()
    }
}