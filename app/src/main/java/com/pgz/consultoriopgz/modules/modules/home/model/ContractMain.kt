package com.pgz.consultoriopgz.modules.modules.home.model

interface ContractMain {
    interface View{

    }

    interface Presenter{
        fun validateIsEnableGoToAddNewSchedule():Boolean
    }
}