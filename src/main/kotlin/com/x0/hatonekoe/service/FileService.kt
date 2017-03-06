package com.x0.hatonekoe.service

import com.x0.hatonekoe.model.ModelManager
import javafx.scene.control.Alert
import javafx.stage.FileChooser
import tornadofx.FileChooserMode
import tornadofx.alert
import tornadofx.chooseFile
import java.io.File
import java.io.FileWriter

object FileService {
    private val allFilter = FileChooser.ExtensionFilter("all files (*.*)", "*.*")
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

        if (!canOpenFile(file)) {
            return
        }

        try {
            val text = file.readText(Charsets.UTF_8)
            ModelManager.textModel.textProperty.set(text)
            ModelManager.fileModel.fileProperty.set(file)
        } catch (e: Exception) {
            println(e)
        }
    }

    /** Check whether file can open */
    fun canOpenFile(targetFile: File): Boolean {
        if (isBigFile(targetFile)) {
            val alertHeader = "File size limit"
            val alertContent = "File size is too large.\nYou can only open files within " +
                displayFileSize(Constant.OPEN_FILE_SIZE_LIMIT_BYTE.toLong()) + "."
            alert(Alert.AlertType.WARNING, alertHeader, alertContent)
            return false
        }

        return true
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
        val fileList = chooseFile(null, arrayOf(allFilter, txtFilter), mode)

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
     * @param targetFile: Check this file whether the extension is .txt
     */
    fun isTextFile(targetFile: File): Boolean {
        return (targetFile.extension == "txt")
    }

    /** Is the file too big?
     *
     * @param targetFile: Check this file size whether over the limit
     */
    fun isBigFile(targetFile: File): Boolean {
        return (targetFile.length() > Constant.OPEN_FILE_SIZE_LIMIT_BYTE)
    }

    /** Display the readable file size
     *
     * @param fileSizeByte: File size (Byte)
     * @return Display the size with the unit for the byte
     */
    fun displayFileSize(fileSizeByte: Long): String {
        var displaySize = fileSizeByte
        var counter = 0

        while (true) {
            if (displaySize < 1_000 || counter > 2) {
                when (counter) {
                    0 -> return "$displaySize Byte"
                    1 -> return "$displaySize KB"
                    2 -> return "$displaySize MB"
                    else -> return "$displaySize GB"
                }
            } else {
                ++counter
                displaySize /= 1_000
            }
        }
    }
}
