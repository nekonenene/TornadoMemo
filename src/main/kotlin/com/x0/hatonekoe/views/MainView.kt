package com.x0.hatonekoe.views

import com.x0.hatonekoe.TextManager
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.bind

class MainView: View("TornadoMemo") {
    override val root: BorderPane by fxml("/styles/MainView.fxml")
    private val menuBarView: MenuBarView by inject()
    val textArea: TextArea by fxid("textArea")
    private val charCounterLabel: Label by fxid("charCounter")

    private val textManager = TextManager()

    init {
        setListeners()
        charCounterLabel.bind(textManager.footerCounterText)
        textManager.update()

        with(root) {
            this.top = menuBarView.root
        }
    }

    fun updateText() {
        textManager.text = textArea.text
        textManager.update()
    }

    /** set event listeners */
    fun setListeners() {
        textArea.setOnKeyReleased { updateText() }
    }
}
