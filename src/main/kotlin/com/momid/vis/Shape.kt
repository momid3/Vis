package com.momid.vis

fun Screen.line(from: p, to: p) {
    val from = cor(from)
    val to = cor(to)
    canvas.strokeLine(from.x, from.y, to.x, to.y)
}

fun Screen.line(from: p, to: p, paint: Paint) {
    val currentPaint = canvas.stroke
    canvas.lineWidth = paint.strokeWidth
    val from = cor(from)
    val to = cor(to)
    canvas.strokeLine(from.x, from.y, to.x, to.y)
}

fun Screen.circle(center: p, radius: Double) {
    val center = cor(center)
    canvas.strokeOval(center.x - radius, center.y - radius, radius * 2, radius * 2)
}

fun Screen.fillCircle(center: p, radius: Double, paint: Paint) {
    val canvasPaint = canvas.fill
    canvas.fill = paint.color.toColor()
    val center = cor(center)
    canvas.fillOval(center.x - radius, center.y - radius, radius * 2, radius * 2)
    canvas.fill = canvasPaint
}

fun Screen.point(coordinates: Point, size: Double = 3.0, paint: Paint = this.paint) {
    fillCircle(coordinates, size, paint)
}

class Path(val screen: Screen, val startingPoint: Point? = null) {
    private var currentPoint: Point? = startingPoint
    fun include(point: Point) {
        if (currentPoint == null) {
            currentPoint = point
        } else {
            screen.line(currentPoint!!, point)
            currentPoint = point
        }
    }
}
