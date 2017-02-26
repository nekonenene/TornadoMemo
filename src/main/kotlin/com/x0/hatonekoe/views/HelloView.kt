package com.x0.hatonekoe.views

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.View
import tornadofx.plusAssign


class HelloView : View("My View") {
    override val root = VBox()

    init {
        root += Button("Press Me")
        root += Label("")
    }
}
