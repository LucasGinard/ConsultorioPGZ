package com.pgz.consultoriopgz.modules.scheduleList.model

interface ScheduleListContract {
    interface View{
        fun showEmptyBanner()
        fun showListSchedule()
        fun validateButtonTrashVisibility()
    }

    interface Presenter{
        fun validateListForShowListOrBanner()
    }
}