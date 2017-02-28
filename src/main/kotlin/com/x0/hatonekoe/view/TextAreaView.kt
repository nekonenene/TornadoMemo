package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.controller.TextAreaController
import javafx.scene.text.Font
import tornadofx.View
import tornadofx.textarea
import tornadofx.useMaxWidth

class TextAreaView: View() {
    val textAreaController: TextAreaController by inject()
    val footerController: FooterController by inject()

    override val root = textarea {
        useMaxWidth = true
        font = Font.font(16.0)
        isWrapText = true

        setOnKeyReleased {
            textAreaController.updateTextDocModel()
            footerController.updateCounter()
        }

        setOnMouseClicked {
            footerController.updateCounter()
        }
    }
}
