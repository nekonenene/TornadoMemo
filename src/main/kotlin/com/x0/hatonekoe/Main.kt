package com.x0.hatonekoe

import com.x0.hatonekoe.views.HelloView
import javafx.application.Application
import tornadofx.App


class HelloWorldApp : App() {
    override val primaryView = HelloView::class
}

fun main(args: Array<String>) {
    Application.launch(HelloWorldApp::class.java, *args)
}
