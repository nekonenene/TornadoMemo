package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.model.ModelManager
import javafx.beans.binding.Bindings
import javafx.geometry.Pos
import tornadofx.*

class FooterView: View() {
    private val footerController: FooterController by inject()

    override val root = hbox {
        alignment = Pos.CENTER_RIGHT

        label {
            useMaxWidth = true
            alignment = Pos.CENTER_RIGHT
            paddingHorizontal = 8
            paddingVertical = 6

            // display the char counter e.g. "Count: 43"
            this.textProperty().bind(Bindings.concat("Count: ", ModelManager.textDocumentModel.charCounterProperty))
        }
    }
}
