package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import com.x0.hatonekoe.model.TextManager
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.bind

class MainView: View("TornadoMemo") {
    private val controller: MainController by inject()

    override val root    : BorderPane by fxml("/styles/MainView.fxml")
    val menuBarView      : MenuBarView by inject()
    val textArea         : TextArea by fxid("textArea")
    val charCounterLabel : Label by fxid("charCounter")

    val textManager = TextManager()

    init {
        println("init Main View")
        setListeners()
        charCounterLabel.bind(textManager.footerCounterText)
        textManager.update()

        with(root) {
            this.top = menuBarView.root
        }
    }

    /** set event listeners */
    fun setListeners() {
        textArea.setOnKeyReleased { controller.updateText() }
    }
}
