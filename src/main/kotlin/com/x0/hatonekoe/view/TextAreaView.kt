package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.TextAreaController
import com.x0.hatonekoe.service.Constant
import com.x0.hatonekoe.service.FileService
import javafx.scene.input.TransferMode
import javafx.scene.text.Font
import tornadofx.View
import tornadofx.textarea
import tornadofx.useMaxWidth
import java.io.File

class TextAreaView: View() {
    val textAreaController: TextAreaController by inject()

    override val root = textarea {
        useMaxWidth = true
        font = Font.font(Constant.TEXTAREA_FONT_SIZE)
        isWrapText = true

        setOnDragOver {
            event -> run {
                val dragBoard = event.dragboard

                if (dragBoard.hasFiles()) {
                    // Change the mouse cursor
                    event.acceptTransferModes(TransferMode.COPY)
                }
            }
        }

        setOnDragDropped {
            event -> run {
                val dragBoard = event.dragboard

                if (dragBoard.files.size == 1) {
                    val file: File = dragBoard.files.first()
                    FileService.openFile(file)
                    event.isDropCompleted = true
                    return@run
                }
                event.isDropCompleted = false
            }
        }
    }
}
