package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.controller.TextAreaController
import tornadofx.View
import tornadofx.textarea
import tornadofx.useMaxWidth

class TextAreaView: View() {
    val textAreaController: TextAreaController by inject()
    val footerController: FooterController by inject()

    override val root = textarea {
        useMaxWidth = true

        setOnKeyReleased {
            textAreaController.updateTextDocModel()
            footerController.updateCounter()
        }
    }
}
