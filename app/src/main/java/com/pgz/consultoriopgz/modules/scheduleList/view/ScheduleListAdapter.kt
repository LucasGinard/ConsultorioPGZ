package com.pgz.consultoriopgz.modules.scheduleList.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentModel

class ScheduleListAdapter(private val scheduleAppointmentList: ArrayList<ScheduleAppointmentModel>,var context:Context) :
    RecyclerView.Adapter<ScheduleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scheduleAppointment = scheduleAppointmentList[position]
        holder.bind(scheduleAppointment)
    }

    override fun getItemCount(): Int {
        return scheduleAppointmentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val clientNameTextView: TextView = itemView.findViewById(R.id.tvUserNameAndLastName)
        private val medicineNameTextView: TextView = itemView.findViewById(R.id.tvMedicineName)
        private val dateTextView: TextView = itemView.findViewById(R.id.tvDate)
        private val timeTextView: TextView = itemView.findViewById(R.id.tvTime)
        private val costTextView: TextView = itemView.findViewById(R.id.tvAmount)
        private val chipMonday: Chip = itemView.findViewById(R.id.chipMonday)
        private val chipTuesday: Chip = itemView.findViewById(R.id.chipTuesday)
        private val chipWednesday: Chip = itemView.findViewById(R.id.chipWednesday)
        private val chipThursday: Chip = itemView.findViewById(R.id.chipThursday)
        private val chipFriday: Chip = itemView.findViewById(R.id.chipFriday)
        private val chipSaturday: Chip = itemView.findViewById(R.id.chipSaturday)
        private val chipSunday: Chip = itemView.findViewById(R.id.chipSunday)

        fun bind(scheduleAppointment: ScheduleAppointmentModel) {
            clientNameTextView.text = "${scheduleAppointment.client?.firstName} ${scheduleAppointment.client?.lastName}"
            medicineNameTextView.text = scheduleAppointment.nameMedicine
            dateTextView.text = scheduleAppointment.date
            timeTextView.text = scheduleAppointment.time
            costTextView.text = scheduleAppointment.amountCost
            scheduleAppointment.daysSelected?.monday?.let { tintChipIfCheck(chipMonday, it) }
            scheduleAppointment.daysSelected?.tuesday?.let { tintChipIfCheck(chipTuesday, it) }
            scheduleAppointment.daysSelected?.wednesday?.let { tintChipIfCheck(chipWednesday, it) }
            scheduleAppointment.daysSelected?.thursday?.let { tintChipIfCheck(chipThursday, it) }
            scheduleAppointment.daysSelected?.friday?.let { tintChipIfCheck(chipFriday, it) }
            scheduleAppointment.daysSelected?.saturday?.let { tintChipIfCheck(chipSaturday, it) }
            scheduleAppointment.daysSelected?.sunday?.let { tintChipIfCheck(chipSunday, it) }
        }

        private fun tintChipIfCheck(chip:Chip,isCheck:Boolean){
            if (isCheck){
                chip.setChipBackgroundColorResource(R.color.blue)
            }else{
                chip.setChipBackgroundColorResource(R.color.gray)
            }
        }
    }
}