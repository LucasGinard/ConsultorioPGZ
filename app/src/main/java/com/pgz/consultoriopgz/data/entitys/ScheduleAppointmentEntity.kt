package com.pgz.consultoriopgz.data.entitys

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
data class ScheduleAppointmentEntity(
    @Embedded val client: ClientEntity?,
    @ColumnInfo(name = "name_medicine") val nameMedicine: String?,
    val date: String?,
    val time: String?,
    @ColumnInfo(name = "amount_cost") val amountCost: String?,
    @Embedded val daysSelected: DaysSelectedEntity?,
    @ColumnInfo(name = "appointment_id") @PrimaryKey(autoGenerate = true) val id: Int = 0
)