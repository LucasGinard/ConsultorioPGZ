package com.pgz.consultoriopgz.modules.scheduleList.model

import com.pgz.consultoriopgz.data.entitys.ScheduleAppointmentEntity

interface ScheduleListContract {
    interface View{
        fun showEmptyBanner()
        fun showListSchedule()
        fun validateButtonTrashVisibility()
        fun updateList()
        fun showError()
    }

    interface Presenter{
        fun validateListForShowListOrBanner()
        fun removeScheduleCheck(scheduleList:ArrayList<ScheduleAppointmentEntity>)
    }
}