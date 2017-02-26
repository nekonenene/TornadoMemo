package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import com.x0.hatonekoe.model.TextManager
import tornadofx.View
import tornadofx.borderpane

class MainView: View("TornadoMemo") {
    private val controller: MainController by inject()
    val menuBarView: MenuBarView by inject()
    val textAreaView: TextAreaView by inject()
    val footerView: FooterView by inject()
    val textManager = TextManager()

    override val root = borderpane {
        top = menuBarView.root
        center = textAreaView.root
        bottom = footerView.root
    }
}
