package com.pgz.consultoriopgz.modules.schedule.model

import android.content.Context
import java.util.Date

interface ScheduleAppointmentContract {
    interface View{
        fun setDateSelected(date:String)
        fun setTimeSelected(time:String)
        fun goHome()
        fun isValidNewSchedule()
        fun isNotValidNewSchedule()
    }

    interface Presenter{
        fun showDatePicker(context: Context)
        fun showTimePicker(context: Context)
        fun addNewScheduleAppointment()
        fun validateFormSchedule()
        fun cleanInputs()
        fun setFormatDecimalMoney(input:String):String
        fun validateIfIsDisableButtonAddSchule(isEnable:Boolean)
        fun validateInputAmount(string:String): Boolean
        fun validateInputNameMedicine(string:String): Boolean
    }
}