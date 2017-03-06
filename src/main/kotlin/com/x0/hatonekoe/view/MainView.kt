package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.service.Constant
import javafx.beans.binding.Bindings
import tornadofx.View
import tornadofx.borderpane

class MainView: View("TornadoMemo") {
    private val mainController: MainController by inject()

    override val root = borderpane {
        println("init Main View")

        top(MenuBarView::class)
        center(TextAreaView::class)
        bottom(FooterView::class)
    }

    init {
        titleProperty.bind(Bindings.concat(Constant.APP_NAME, ModelManager.fileModel.mainWindowTitleProperty))
    }
}
