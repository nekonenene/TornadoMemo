package com.x0.hatonekoe.model

import javafx.beans.property.SimpleObjectProperty
import tornadofx.ViewModel
import java.io.File

/**
 * text: text in the textArea
 * charCounter: counter of characters
 */
class FileModel : ViewModel() {
    val fileProperty = SimpleObjectProperty<File>(null)

    val file = bind { fileProperty }
}
