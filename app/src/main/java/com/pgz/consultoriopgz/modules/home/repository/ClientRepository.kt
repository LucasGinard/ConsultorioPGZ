package com.pgz.consultoriopgz.modules.home.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import kotlinx.coroutines.GlobalScope

class MainRepository {

    suspend fun getClientes():ArrayList<ClientEntity> {
        return ConsultorioPGZAPP.database.clientDao().getAllClients() as ArrayList<ClientEntity>
    }

}