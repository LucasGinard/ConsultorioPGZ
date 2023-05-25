package com.pgz.consultoriopgz.modules.modules.client.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ClientModel(
    var firstName:String,
    var lastName:String,
    var idClient:Int,
    var numberContact:String
)

@Entity(tableName = "clients")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "id_client") val idClient: Int,
    @ColumnInfo(name = "number_contact") val numberContact: String
)