package com.pgz.consultoriopgz.modules.scheduleList.model

interface ScheduleListContract {
    interface View{
        fun showEmptyBanner()
        fun showListSchedule()
    }

    interface Presenter{
        fun validateListForShowListOrBanner()
    }
}