package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.view.TextAreaView
import tornadofx.Controller

class TextAreaController: Controller() {
    val textAreaView: TextAreaView by inject()
    val textArea = textAreaView.root

    /** TextArea の中身を全選択 */
    fun selectAll() {
        textArea.selectAll()
    }

    /** 選択範囲をコピー */
    fun copyText() {
        textArea.copy()
    }

    /** 選択範囲を切り取り */
    fun cutText() {
        textArea.cut()
    }

    /** TextArea にクリップボードから貼り付け */
    fun pasteText() {
        textArea.paste()
    }

    /** TextArea の中身に合わせて TextDocumentModel の中身を更新 */
    fun updateTextDocModel() {
        ModelManager.textDocumentModel.text.value = textArea.text
    }
}
