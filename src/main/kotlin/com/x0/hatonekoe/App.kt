package com.x0.hatonekoe

import com.x0.hatonekoe.view.MainView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

fun main(args: Array<String>) {
    Application.launch(TornadoMemoApp::class.java, *args)
}

class TornadoMemoApp: App() {
    override val primaryView = MainView::class

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = false
        stage.minWidth  = 280.0
        stage.minHeight = 150.0
    }
}
