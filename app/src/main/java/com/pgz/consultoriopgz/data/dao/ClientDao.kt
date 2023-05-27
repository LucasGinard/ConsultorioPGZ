package com.pgz.consultoriopgz.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pgz.consultoriopgz.data.entitys.ClientEntity

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients")
    suspend fun getAllClients(): List<ClientEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: ClientEntity)

    @Delete
    suspend fun deleteClient(client: ClientEntity)
}