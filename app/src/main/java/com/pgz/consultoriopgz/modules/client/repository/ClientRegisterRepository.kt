package com.pgz.consultoriopgz.modules.client.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ClientEntity

class ClientRegisterRepository {

    suspend fun insertClient(client: ClientEntity) {
        ConsultorioPGZAPP.database.clientDao().insertClient(client)
    }

}