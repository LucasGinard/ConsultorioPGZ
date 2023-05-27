package com.pgz.consultoriopgz.modules.schedule.model

import android.content.Context
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity
import java.util.Date

interface ScheduleAppointmentContract {
    interface View{
        fun setDateSelected(date:String)
        fun setTimeSelected(time:String)
        fun goHome()
        fun isValidNewSchedule()
        fun isNotValidNewSchedule()
        fun showError()
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
        suspend fun addScheduleIntoDataBase(schudeleSave: ScheduleAppointmentEntity)
    }
}