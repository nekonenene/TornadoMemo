package com.x0.hatonekoe.controller

import com.x0.hatonekoe.view.MainView
import tornadofx.Controller

class MainController: Controller() {
    val mainView: MainView by inject()
    /*
    val textArea = mainView.textArea
    val textManager = mainView.textManager

    fun updateText() {
        textManager.text = textArea.text
        textManager.update()
    }

    fun selectAll() {
        textArea.selectAll()
    }
    */
}
