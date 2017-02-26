package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import javafx.geometry.Pos
import tornadofx.View
import tornadofx.hbox
import tornadofx.label
import tornadofx.useMaxWidth

class FooterView: View() {
    val footerController: FooterController by inject()

    override val root = hbox {
        label("Count: 0") {
            useMaxWidth = true
            alignment = Pos.CENTER_RIGHT
        }
    }
}
