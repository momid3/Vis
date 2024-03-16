package com.momid.vis

import javafx.application.Application

internal lateinit var start: Screen.() -> Unit

fun showGraphics(onStart: Screen.() -> Unit) {
    start = onStart
    Application.launch(Graphics::class.java)
}
