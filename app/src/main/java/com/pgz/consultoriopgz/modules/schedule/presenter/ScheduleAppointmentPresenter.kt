package com.pgz.consultoriopgz.modules.schedule.presenter

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentContract
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ScheduleAppointmentPresenter(var view:ScheduleAppointmentContract.View): ScheduleAppointmentContract.Presenter {

    var dateSelected:Date ?= null
    override fun showDatePicker(context: Context) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, day)
                dateSelected = selectedCalendar.time
                val formattedDate = formatDate(dateSelected ?: Date())
                view.setDateSelected(formattedDate)
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
}