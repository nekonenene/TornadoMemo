package com.x0.hatonekoe.controller

import com.x0.hatonekoe.view.TextAreaView
import tornadofx.Controller

class TextAreaController: Controller() {
    private val mainController: MainController by inject()
    val textAreaView: TextAreaView by inject()
    val textArea = textAreaView.root

    /** TextArea の中身を全選択 */
    fun selectAll() {
        textArea.selectAll()
    }

    /** TextArea の中身に合わせて TextDocumentModel の中身を更新 */
    fun updateTextDocModel() {
        mainController.textDocModel.text.value = textArea.text
    }
}
