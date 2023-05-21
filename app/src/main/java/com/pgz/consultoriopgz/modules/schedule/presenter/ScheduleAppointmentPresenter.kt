package com.pgz.consultoriopgz.modules.schedule.presenter

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.TimePicker
import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentContract
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentModel
import com.pgz.consultoriopgz.modules.utils.SessionCache
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ScheduleAppointmentPresenter(var view:ScheduleAppointmentContract.View): ScheduleAppointmentContract.Presenter {

    var dateSelected:String ?= null
    var timeSelected:String ?= null
    var selectClient:ClientModel ?= null
    var selectDoctor:String ?= null

    override fun addNewScheduleAppointment() {
        SessionCache.listSchedules.add(ScheduleAppointmentModel(selectClient ,selectDoctor,dateSelected,timeSelected))
        view.goHome()
    }

    override fun validateFormSchedule() {
        if (dateSelected.isNullOrEmpty() || timeSelected.isNullOrEmpty() || selectClient == null || selectDoctor.isNullOrEmpty()){
            view.isNotValidNewSchedule()
        }else{
            view.isValidNewSchedule()
        }
    }

    override fun cleanInputs() {
        dateSelected = null
        timeSelected = null
        selectClient = null
        selectDoctor = null
        validateFormSchedule()
    }

    override fun showDatePicker(context: Context) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, day)
                dateSelected = formatDate(selectedCalendar.time ?: Date())
                view.setDateSelected(dateSelected ?: "")
                validateFormSchedule()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

    private fun formatDate(date: Date): String {
        val format = SimpleDateFormat("dd MMMM yyyy", Locale("es", "ES"))
        return format.format(date)
    }

    override fun showTimePicker(context: Context) {
        val calendar = Calendar.getInstance()

        val timePickerDialog = TimePickerDialog(
            context,
            { _: TimePicker, hourOfDay: Int, minute: Int ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                val selectedTime = calendar.time
                val formattedTime = formatTime(selectedTime)
                timeSelected = formattedTime
                view.setTimeSelected(formattedTime)
                validateFormSchedule()
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )

        timePickerDialog.show()
    }


    private fun formatTime(date: Date): String {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        return format.format(date)
    }
}