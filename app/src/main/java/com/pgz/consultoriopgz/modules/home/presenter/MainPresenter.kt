package com.pgz.consultoriopgz.modules.home.presenter

import com.pgz.consultoriopgz.modules.home.model.ContractMain
import com.pgz.consultoriopgz.modules.home.repository.MainRepository
import com.pgz.consultoriopgz.utils.SessionCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(var view: ContractMain.View): ContractMain.Presenter {

    val repository = MainRepository()
    override fun validateIsEnableGoToAddNewSchedule(): Boolean {
        return SessionCache.listClients.isNotEmpty()
    }

    override fun getClientsSave() {
        GlobalScope.launch(Dispatchers.IO) {
            SessionCache.listClients = repository.getClientes()
        }
    }

}