package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.TextDocument
import com.x0.hatonekoe.model.TextDocumentModel
import com.x0.hatonekoe.view.MainView
import tornadofx.Controller

class MainController: Controller() {
    val mainView: MainView by inject()
    val textDocModel = TextDocumentModel(TextDocument())
}
