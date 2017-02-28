package com.x0.hatonekoe.controller

import com.x0.hatonekoe.view.TextAreaView
import tornadofx.Controller

class TextAreaController: Controller() {
    val textAreaView: TextAreaView by inject()
    val textArea = textAreaView.root
    val footerController: FooterController by inject()

    /** select all text in TextArea */
    fun selectAll() {
        textArea.selectAll()
    }

    /** copy selected text */
    fun copyText() {
        textArea.copy()
    }

    /** cut selected text */
    fun cutText() {
        textArea.cut()
    }

    /** paste to TextArea from ClipBoard */
    fun pasteText() {
        textArea.paste()
    }

    /** set text in TextArea */
    fun setText(text: String) {
        textArea.text = text
        footerController.updateCounter()
    }

    /** get text in TextArea */
    fun getText(): String {
        return textArea.text
    }
}
