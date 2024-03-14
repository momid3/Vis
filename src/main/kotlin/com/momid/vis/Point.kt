package com.momid.vis

class Point(val x: Double, val y: Double)

typealias p = Point

fun Screen.cor(point: Point): Point {
    return Point(point.x, this.height - point.y)
}
