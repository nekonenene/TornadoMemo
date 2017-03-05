package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.view.MenuBarView
import javafx.stage.FileChooser
import tornadofx.Controller
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import java.io.FileWriter

class MenuBarController: Controller() {
    val menuBarView: MenuBarView by inject()
    val textAreaController: TextAreaController by inject()

    /** Open a file and set the text in the textArea */
    fun openFile() {
        val txtFilter = FileChooser.ExtensionFilter("text files (*.txt)", "*.txt")
        val fileList = chooseFile(null, arrayOf(txtFilter), FileChooserMode.Single)
        val file =
            if (fileList.isEmpty()) {
                return // END
            } else {
                fileList.first()
            }

        try {
            val text = file.readText(Charsets.UTF_8)
            ModelManager.textModel.textProperty.set(text)
        } catch (e: Exception) {
            println(e)
        }
    }

    /** Save the textArea to new file */
    fun writeFile() {
        val txtFilter = FileChooser.ExtensionFilter("text files (*.txt)", "*.txt")
        val fileList = chooseFile(null, arrayOf(txtFilter), FileChooserMode.Save)
        val targetFile =
            if (fileList.isEmpty()) {
                return // END
            } else {
                fileList.first()
            }

        try {
            val text = ModelManager.textModel.text.value
            val fileWriter = FileWriter(targetFile)
            fileWriter.write(text)
            fileWriter.close()
        } catch (e: Exception) {
            println(e)
        }
    }
}
