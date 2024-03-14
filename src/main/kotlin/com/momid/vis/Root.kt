package com.momid.vis

internal var privateRoot: Screen? = null

val root: Screen
    get() {
        return privateRoot!!
    }
