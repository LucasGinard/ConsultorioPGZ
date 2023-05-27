package com.pgz.consultoriopgz.modules.home.model

interface ContractMain {
    interface View{

    }

    interface Presenter{
        fun validateIsEnableGoToAddNewSchedule():Boolean
        fun getClientsSave()
        fun getSchedulesSave()
    }
}