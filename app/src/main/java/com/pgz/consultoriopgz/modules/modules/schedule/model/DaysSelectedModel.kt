package com.pgz.consultoriopgz.modules.modules.schedule.model

data class DaysSelectedModel (
    var monday:Boolean ?= true,
    var tuesday:Boolean ?= false,
    var wednesday:Boolean ?= false,
    var thursday:Boolean ?= false,
    var friday:Boolean ?= false,
    var saturday:Boolean ?= false,
    var sunday:Boolean ?= false,
)