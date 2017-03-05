package com.x0.hatonekoe.controller

import com.x0.hatonekoe.model.ModelManager
import com.x0.hatonekoe.view.MenuBarView
import javafx.stage.FileChooser
import tornadofx.Controller
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import java.io.File
import java.io.FileWriter

class MenuBarController: Controller() {
    val menuBarView: MenuBarView by inject()

    private val txtFilter = FileChooser.ExtensionFilter("text files (*.txt)", "*.txt")

    /** Open a file and set the text in the textArea */
    fun openFile() {
        val file = chooseTextFile(FileChooserMode.Single) ?: return

        try {
            val text = file.readText(Charsets.UTF_8)
            ModelManager.textModel.textProperty.set(text)
            ModelManager.fileModel.fileProperty.set(file)
        } catch (e: Exception) {
            println(e)
        }
    }

    /** Save the textArea to a file
     *
     * @param targetFile: Save to this file. If this parameter is null, Save to new file.
     */
    fun writeFile(targetFile: File? = null) {
        val file: File

        if (targetFile == null) {
            // If the user didn't select, then finish this method.
            file = chooseTextFile(FileChooserMode.Save) ?: return
        } else {
            file = targetFile
        }

        try {
            val text = ModelManager.textModel.text.value
            val fileWriter = FileWriter(file)
            fileWriter.write(text)
            fileWriter.close()

            ModelManager.fileModel.fileProperty.set(file)
        } catch (e: Exception) {
            println(e)
        }
    }

    /** Open the dialog for choose a file
     *
     * @param mode: Use FileChooserMode.Single or FileChooserMode.Save
     */
    private fun chooseTextFile(mode: FileChooserMode): File? {
        val fileList = chooseFile(null, arrayOf(txtFilter), mode)

        val file =
            if (fileList.isEmpty()) {
                null
            } else {
                fileList.first()
            }

        return file
    }
}
