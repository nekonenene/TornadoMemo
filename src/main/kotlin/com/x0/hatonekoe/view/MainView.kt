package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import tornadofx.View
import tornadofx.borderpane

class MainView: View("TornadoMemo") {
    private val controller: MainController by inject()
    val menuBarView: MenuBarView by inject()
    val textAreaView: TextAreaView by inject()
    val footerView: FooterView by inject()

    override val root = borderpane {
        println("init Main View")

        top = menuBarView.root
        center = textAreaView.root
        bottom = footerView.root
    }

    init {
        title = "Tornado Memo"
    }
}
