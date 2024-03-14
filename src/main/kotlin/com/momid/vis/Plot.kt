package com.momid.vis

fun Screen.plot() {
    paint.strokeWidth = 1.0
    paint.color = Color(70, 70, 70, 0xff)
    for (w in 0 until width.toInt() step 7) {
        line(p(w.toDouble(), 0.0), p(w.toDouble(), height))
    }

    for (h in 0 until height.toInt() step 7) {
        line(p(0.0, h.toDouble()), p(width, h.toDouble()))
    }
}
