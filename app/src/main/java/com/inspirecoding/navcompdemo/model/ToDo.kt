package com.inspirecoding.navcompdemo.model

import com.inspirecoding.navcompdemo.utils.Prioirities

data class ToDo(
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var priority: Prioirities = Prioirities.LOW
)