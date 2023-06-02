package com.pgz.consultoriopgz.modules.client.presenter

import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.modules.client.model.ClientListContract
import com.pgz.consultoriopgz.modules.client.repository.ClientListrRepository
import com.pgz.consultoriopgz.utils.SessionCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ClientListPresenter(val view:ClientListContract.View):ClientListContract.Presenter {

    private val repository = ClientListrRepository()


    override fun deleteClient(selectClient:ArrayList<ClientEntity>) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                selectClient.forEach{client ->
                    repository.deleteClient(client)
                    SessionCache.listClients.remove(client)
                }
                SessionCache.listCheckToDeleteClient.clear()
                launch(Dispatchers.Main) {
                    view.updateListClient()
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    view.showError()
                }
            }
        }
    }
}