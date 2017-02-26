package com.x0.hatonekoe.controller

import com.x0.hatonekoe.view.FooterView
import tornadofx.Controller

class FooterController: Controller() {
    private val mainController: MainController by inject()
    val footerView: FooterView by inject()

    /** フッターに表示している文字数カウンタを更新 */
    fun updateCounter() {
        val charCount = mainController.textDocModel.text.value?.length ?: 0
        mainController.textDocModel.charCounterText.value = "Count: $charCount"
    }
}
