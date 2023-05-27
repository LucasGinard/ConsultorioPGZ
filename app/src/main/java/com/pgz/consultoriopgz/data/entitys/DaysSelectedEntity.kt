package com.pgz.consultoriopgz.data.entitys

data class DaysSelectedEntity(
    var monday: Boolean = true,
    var tuesday: Boolean = false,
    var wednesday: Boolean = false,
    var thursday: Boolean = false,
    var friday: Boolean = false,
    var saturday: Boolean = false,
    var sunday: Boolean = false
)