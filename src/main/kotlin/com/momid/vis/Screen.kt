package com.momid.vis

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext

class Screen(val width: Double, val height: Double) {
    internal lateinit var canvas: GraphicsContext
    val paint: Paint = Paint()
    val area = Area(0.0, width, 0.0, height)
}
