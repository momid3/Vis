package com.momid.vis

import javafx.application.Application

internal lateinit var start: () -> Unit

fun showGraphics(onStart: () -> Unit) {
    start = onStart
    Application.launch(Graphics::class.java)
}
