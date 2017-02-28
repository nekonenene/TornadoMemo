package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.view.TextAreaView
import tornadofx.Controller

class TextAreaController: Controller() {
    val textAreaView: TextAreaView by inject()
    val textArea = textAreaView.root

    /** select all text in TextArea */
    fun selectAll() {
        textArea.selectAll()
    }

    /** copy selected text */
    fun copyText() {
        textArea.copy()
        updateTextDocModel()
    }

    /** cut selected text */
    fun cutText() {
        textArea.cut()
        updateTextDocModel()
    }

    /** paste to TextArea from ClipBoard */
    fun pasteText() {
        textArea.paste()
        updateTextDocModel()
    }

    /** TextArea の中身に合わせて TextDocumentModel の中身を更新 */
    fun updateTextDocModel() {
        ModelManager.textDocumentModel.text.value = textArea.text
    }

    /** set text in TextArea */
    fun setText(text: String) {
        textArea.text = text
    }

    /** get text in TextArea */
    fun getText(): String {
        return textArea.text
    }
}
