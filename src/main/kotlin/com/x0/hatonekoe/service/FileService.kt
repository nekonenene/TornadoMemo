package com.x0.hatonekoe.service

import com.x0.hatonekoe.model.ModelManager
import javafx.stage.FileChooser
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import java.io.File
import java.io.FileWriter

object FileService {
    private val txtFilter = FileChooser.ExtensionFilter("text files (*.txt)", "*.txt")

    /** Open a file and set the text in the textArea */
    fun openFile(targetFile: File? = null) {
        val file: File

        if (targetFile == null) {
            // If the user didn't select, then finish this method.
            file = chooseTextFile(FileChooserMode.Single) ?: return
        } else {
            file = targetFile
        }

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
    fun chooseTextFile(mode: FileChooserMode): File? {
        val fileList = chooseFile(null, arrayOf(txtFilter), mode)

        val file =
            if (fileList.isEmpty()) {
                null
            } else {
                fileList.first()
            }

        return file
    }

    /** Is the file .txt?
     *
     * @param targetFile: Check this file if is .txt or not
     */
    fun isTextFile(targetFile: File): Boolean {
        return (targetFile.extension == "txt")
    }
}
