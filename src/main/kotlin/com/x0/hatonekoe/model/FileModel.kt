package com.x0.hatonekoe.model

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel
import java.io.File

/**
 * text: text in the textArea
 * charCounter: counter of characters
 */
class FileModel : ViewModel() {
    val fileProperty = SimpleObjectProperty<File>(null)
    val mainWindowTitleProperty = SimpleStringProperty("")

    val file = bind { fileProperty }

    init {
        fileProperty.addListener {
            _, _, newValue -> run {
                if (newValue == null) {
                    mainWindowTitleProperty.set("")
                } else {
                    mainWindowTitleProperty.set(" [" + newValue.name + "]")
                }
            }
        }
    }

    fun reset() {
        fileProperty.set(null)
    }
}
