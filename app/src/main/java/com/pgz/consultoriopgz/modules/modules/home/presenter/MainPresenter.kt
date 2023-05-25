package com.pgz.consultoriopgz.modules.modules.home.presenter

import com.pgz.consultoriopgz.modules.modules.home.model.ContractMain
import com.pgz.consultoriopgz.modules.utils.SessionCache

class MainPresenter(var view: ContractMain.View): ContractMain.Presenter {

    override fun validateIsEnableGoToAddNewSchedule(): Boolean {
        return SessionCache.listClients.isNotEmpty()
    }

}