package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import com.x0.hatonekoe.controller.TextAreaController
import com.x0.hatonekoe.model.ModelManager
import javafx.scene.text.Font
import tornadofx.View
import tornadofx.bind
import tornadofx.textarea
import tornadofx.useMaxWidth

class TextAreaView: View() {
    val textAreaController: TextAreaController by inject()
    val footerController: FooterController by inject()

    override val root = textarea {
        useMaxWidth = true
        font = Font.font(16.0)
        isWrapText = true

        // bind bidirectional
        bind(ModelManager.textDocumentModel.text)
        ModelManager.textDocumentModel.text.bind(this.textProperty())

        setOnKeyReleased {
            footerController.updateCounter()
        }

        setOnMouseClicked {
            footerController.updateCounter()
        }
    }
}
