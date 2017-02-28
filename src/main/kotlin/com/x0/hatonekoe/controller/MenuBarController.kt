package com.x0.hatonekoe.controller

import com.x0.hatonekoe.view.MenuBarView
import javafx.stage.FileChooser
import tornadofx.Controller
import tornadofx.FileChooserMode
import tornadofx.chooseFile

class MenuBarController: Controller() {
    val menuBarView: MenuBarView by inject()
    val textAreaController: TextAreaController by inject()

    fun openFile() {
        val txtFilter = FileChooser.ExtensionFilter("text files (*.txt)", "*.txt")
        val fileList = chooseFile("Open text file", arrayOf(txtFilter), FileChooserMode.Single)
        if (fileList.isEmpty()) {
            return
        }

        val file = fileList.first()

        try {
            val text = file.readText(Charsets.UTF_8)
            textAreaController.setText(text)
            textAreaController.updateTextDocModel()
        } catch (e: Exception) {
            println(e)
        }
    }
}
