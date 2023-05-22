package com.pgz.consultoriopgz.modules.schedule.presenter

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.TimePicker
import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.schedule.model.DaysSelectedModel
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentContract
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentModel
import com.pgz.consultoriopgz.modules.utils.SessionCache
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ScheduleAppointmentPresenter(var view:ScheduleAppointmentContract.View): ScheduleAppointmentContract.Presenter {

    var dateSelected:String ?= null
    var timeSelected:String ?= null
    var selectClient:ClientModel ?= null
    var nameMedicine:String ?= null
    var amountCost:String ?= null
    var daysSelected: DaysSelectedModel = DaysSelectedModel()

    override fun addNewScheduleAppointment() {
        SessionCache.listSchedules.add(ScheduleAppointmentModel(selectClient ,nameMedicine,dateSelected,timeSelected,amountCost,daysSelected))
        view.goHome()
    }

    override fun validateFormSchedule() {
        if (dateSelected.isNullOrEmpty() || timeSelected.isNullOrEmpty() || selectClient == null || nameMedicine.isNullOrEmpty() || amountCost.isNullOrEmpty()){
            view.isNotValidNewSchedule()
        }else{
            view.isValidNewSchedule()
        }
    }

    override fun cleanInputs() {
        dateSelected = null
        timeSelected = null
        selectClient = null
        nameMedicine = null
        amountCost = null
        validateFormSchedule()
    }

    override fun setFormatDecimalMoney(input: String): String {
        try {
            var originalString = input.replace(".",",").replace("Gs ","")
            if (originalString.contains(",")) {
                originalString = originalString.replace(",".toRegex(), "")
            }
            val longval: Long = originalString.toLong()
            val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
            formatter.applyPattern("#,###,###,###")
            val formattedString = formatter.format(longval)
            amountCost = "Gs ${formattedString.replace(",",".")}"
            return amountCost as String
        } catch (nfe: NumberFormatException) {
            nfe.printStackTrace()
        }
        return  input
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

    override fun validateIfIsDisableButtonAddSchule(isEnable:Boolean){
        if (!isEnable) view.isNotValidNewSchedule()
    }

    override fun validateInputAmount(string: String): Boolean {
        val isValid = validateInputNotEmptyOrBlank(string)
        validateIfIsDisableButtonAddSchule(isValid)
        return isValid
    }

    override fun validateInputNameMedicine(string: String): Boolean {
        val isValid = validateInputNotEmptyOrBlank(string)
        if (isValid) nameMedicine = string
        validateIfIsDisableButtonAddSchule(isValid)
        return isValid
    }

    private fun validateInputNotEmptyOrBlank(input:String):Boolean{
        return input.isNotEmpty()
    }
}