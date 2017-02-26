package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.TextAreaController
import tornadofx.View
import tornadofx.textarea
import tornadofx.useMaxWidth

class TextAreaView: View() {
    val textAreaController: TextAreaController by inject()

    override val root = textarea {
        useMaxWidth = true
    }
}

/*
    init {
        println("init Main View")
        setListeners()
        charCounterLabel.bind(textManager.footerCounterText)
        textManager.update()

        with(root) {
            this.top = menuBarView.root
        }
    }

    /** set event listeners */
    fun setListeners() {
        textArea.setOnKeyReleased { controller.updateText() }
    }

 */
