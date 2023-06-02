package com.pgz.consultoriopgz.modules.client.model

import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.utils.SessionCache

interface ClientListContract {

    interface View{
        fun validateShowList(hideList:Boolean = SessionCache.listClients.isNotEmpty())
        fun deleteClientsSelect(listDelete:ArrayList<ClientEntity>)
        fun updateListClient()
        fun showError()
        fun showDeleteButton()
        fun hideDeleteButton()
    }

    interface Presenter{
        fun deleteClient(selectClient:ArrayList<ClientEntity>)
    }
}