package com.momid.vis

import java.text.DecimalFormat

internal val doubleFormat = DecimalFormat("#.${"#".repeat(3)}")

fun Screen.plot(area: Area, gap: Double, margin: Double, xScale: Double = 1.0, yScale: Double = 1.0) {
    paint.strokeWidth = 0.3
    paint.color = Color(70, 70, 70, 0xff)
    paint.font = Font(paint.font.color, 10)
    val textSize = paint.font.size

    val wRange = (area.left + margin).toInt() until (area.right - margin).toInt() step gap.toInt()
    val wRangeMax = wRange.last
    val hRange = (area.bottom + margin).toInt() until (area.top - margin).toInt() step gap.toInt()
    val hRangeMax = hRange.last

    var wIndex = 0
    var hIndex = 0

    for (w in wRange) {
        line(p(w.toDouble(), margin), p(w.toDouble(), hRangeMax.toDouble()))
        if (wIndex != 0) {
            val text = value(wIndex * xScale)
            text(text, p(w.toDouble() - textWMiddle(text, textSize.toDouble()), margin - (textSize + 10)))
        }
        wIndex += 1
    }

    for (h in hRange) {
        line(p(margin, h.toDouble()), p(wRangeMax.toDouble(), h.toDouble()))
        if (hIndex != 0) {
            val text = value(hIndex * yScale)
            text(text, p(margin - (textWSize(text, textSize.toDouble()) + 10), h.toDouble() - textHMiddle(textSize.toDouble())))
        }
        hIndex += 1
    }
}

fun textWSize(text: String, textSize: Double): Double {
    return text.length * textSize * 0.5
}

fun textWMiddle(text: String, textSize: Double): Double {
    return text.length * textSize * 0.5 * 0.5
}

fun textHMiddle(textSize: Double): Double {
    return textSize * 0.5
}

internal fun value(value: Double): String {
    return doubleFormat.format(value)
}
