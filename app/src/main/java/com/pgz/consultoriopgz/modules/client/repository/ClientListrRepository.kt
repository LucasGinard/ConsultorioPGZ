package com.pgz.consultoriopgz.modules.client.repository

import com.pgz.consultoriopgz.ConsultorioPGZAPP
import com.pgz.consultoriopgz.data.entitys.ClientEntity

class ClientListrRepository {

    suspend fun deleteClient(client: ClientEntity) {
        ConsultorioPGZAPP.database.clientDao().deleteClient(client)
    }

}