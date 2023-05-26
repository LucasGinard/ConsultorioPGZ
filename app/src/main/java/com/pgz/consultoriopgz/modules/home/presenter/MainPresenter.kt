package com.pgz.consultoriopgz.modules.home.presenter

import com.pgz.consultoriopgz.modules.home.model.ContractMain
import com.pgz.consultoriopgz.utils.SessionCache

class MainPresenter(var view: ContractMain.View): ContractMain.Presenter {

    override fun validateIsEnableGoToAddNewSchedule(): Boolean {
        return SessionCache.listClients.isNotEmpty()
    }

}