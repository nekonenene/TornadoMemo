package com.x0.hatonekoe.views

import javafx.scene.control.Button
import tornadofx.*

class MainView: View("TornadoMemo") {
    val menuBarView: MenuBarView by inject()

    override val root = borderpane {
        top = menuBarView.root
        center = vbox()
        bottom = label("Hello, pretty user!")
    }

    init {
        with(root.center) {
            this += Button("Push me!")
        }
    }
}
