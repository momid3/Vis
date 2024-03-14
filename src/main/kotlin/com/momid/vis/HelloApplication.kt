package com.momid.vis

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import kotlin.math.sin
import kotlin.random.Random

class Graphics : Application() {
    override fun start(stage: Stage) {
        val pane = Pane()
        val scene = Scene(pane)
        stage.title = "Hello!"
        stage.scene = scene
        stage.isMaximized = true
        stage.show()
        val canvas = Canvas(pane.width, pane.height)
        privateRoot = Screen(pane.width, pane.height)
        root.canvas = canvas.graphicsContext2D
        root.paint.canvas = canvas
        val context = canvas.graphicsContext2D
        context.lineWidth = root.paint.strokeWidth
        context.stroke = root.paint.color.toColor()
        context.fill = root.paint.color.toColor()
        start()
        context.lineWidth = 3.0
//        context.strokeLine(0.0, 0.0, pane.width, pane.height)
        pane.children.add(canvas)
    }
}

fun main() {
    showGraphics {
        with(root) {
            val center = p(root.width / 2, height / 2)
//            line(p(0.0, 0.0), p(300.0, 300.0))
            circle(center, 370.0)
            plot()
            val path = Path(this, p(0.0, 0.0))
            startAnimation(3000) {
//                circle(p(Random.nextDouble(0.0, 300.0), Random.nextDouble(0.0, 300.0)), 37.0)
                val x = it.toDouble() / 3000 * 7
                path.include(p(x * 300, sin(x * 7) * 300))
                val x0 = x - 0.1
                if (Random.nextInt(7) == 0) {
                    point(p(x0 * 300, sin(x0 * 7) * 300), 3.8, color(0xff - 30, 37, 37, 0xff))
                }
                Thread.sleep(1)
            }
        }
    }
}
