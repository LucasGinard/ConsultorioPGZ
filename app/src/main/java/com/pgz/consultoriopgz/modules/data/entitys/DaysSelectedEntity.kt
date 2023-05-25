package com.pgz.consultoriopgz.modules.data.entitys

data class DaysSelectedEntity(
    val monday: Boolean = true,
    val tuesday: Boolean = false,
    val wednesday: Boolean = false,
    val thursday: Boolean = false,
    val friday: Boolean = false,
    val saturday: Boolean = false,
    val sunday: Boolean = false
)