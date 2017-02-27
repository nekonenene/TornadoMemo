package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.view.FooterView
import tornadofx.Controller

class FooterController: Controller() {
    val footerView: FooterView by inject()

    /** フッターに表示している文字数カウンタを更新 */
    fun updateCounter() {
        val charCount = ModelManager.textDocumentModel.text.value?.length ?: 0
        ModelManager.textDocumentModel.charCounterText.value = "Count: $charCount"
    }
}
