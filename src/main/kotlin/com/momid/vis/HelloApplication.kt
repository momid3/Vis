package com.momid.vis.vis

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val stackPane = StackPane()
        val scene = Scene(stackPane, 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}