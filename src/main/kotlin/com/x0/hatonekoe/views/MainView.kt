package com.x0.hatonekoe.views

import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.button
import tornadofx.plusAssign

class MainView: View("TornadoMemo") {
    override val root: BorderPane by fxml("/styles/MainView.fxml")
    val menuBarView: MenuBarView by inject()
    val charCounterLabel: Label by fxid("charCounter")
    val count = 5

    init {
        charCounterLabel.text = count.toString()

        with(root) {
            this.top = menuBarView.root
            this.center += button("Push me!")
        }
    }
}
