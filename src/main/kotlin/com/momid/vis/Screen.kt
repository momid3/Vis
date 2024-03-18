package com.momid.vis

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext

class Screen(val width: Double, val height: Double) {
    val center = Point(width / 2, height / 2)
    internal lateinit var canvas: GraphicsContext
    val paint: Paint = Paint()
    val area = Area(0.0, width, 0.0, height)
}
