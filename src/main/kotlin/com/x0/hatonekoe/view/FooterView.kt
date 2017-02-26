package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.controller.MainController
import javafx.geometry.Pos
import tornadofx.View
import tornadofx.hbox
import tornadofx.label
import tornadofx.useMaxWidth

class FooterView: View() {
    private val mainController: MainController by inject()
    private val footerController: FooterController by inject()

    override val root = hbox {
        alignment = Pos.CENTER_RIGHT

        label(mainController.textDocModel.charCounterText) {
            useMaxWidth = true
            alignment = Pos.CENTER_RIGHT
        }
    }

    init {
        footerController.updateCounter()
    }
}
