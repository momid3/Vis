package com.momid.vis

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext

class Screen(val width: Double, val height: Double) {
    internal lateinit var canvas: GraphicsContext
    var paint: Paint = Paint()
}
