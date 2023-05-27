package com.pgz.consultoriopgz.data.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class ClientEntity(
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "id_client") val idClient: Int,
    @ColumnInfo(name = "number_contact") val numberContact: String,
    @ColumnInfo(name = "client_id") @PrimaryKey(autoGenerate = true) var id: Int = 0
)