package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.controller.MainController
import javafx.geometry.Pos
import tornadofx.*

class FooterView: View() {
    private val mainController: MainController by inject()
    private val footerController: FooterController by inject()

    override val root = hbox {
        alignment = Pos.CENTER_RIGHT

        label(mainController.textDocModel.charCounterText) {
            useMaxWidth = true
            alignment = Pos.CENTER_RIGHT
            paddingHorizontal = 8
            paddingVertical = 6
        }
    }

    init {
        footerController.updateCounter()
    }
}
