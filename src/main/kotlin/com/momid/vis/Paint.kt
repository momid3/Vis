package com.momid.vis

import javafx.scene.canvas.Canvas

open class Paint(
    strokeWidth: Double = 3.0,
    color: Color = Color(30, 30, 30, 0xff)
) {
    var strokeWidth = strokeWidth
        set(value) {
            canvas.graphicsContext2D.lineWidth = value
            field = value
        }
    var color = color
        set(value) {
            canvas.graphicsContext2D.stroke = value.toColor()
            canvas.graphicsContext2D.fill = value.toColor()
            field = value
        }
    internal lateinit var canvas: Canvas
}

class Color(val r: Int, val g: Int, val b: Int, val a: Int = 0xff)

fun color(r: Int, g: Int, b: Int, a: Int = 0xff): Paint {
    return Paint(color = Color(r, g, b, a))
}

fun Color.toColor(): javafx.scene.paint.Color {
    return javafx.scene.paint.Color(this.r.toDouble() / 0xff, this.g.toDouble() / 0xff, this.b.toDouble() / 0xff, this.a.toDouble() / 0xff)
}
