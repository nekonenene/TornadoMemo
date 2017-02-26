package com.x0.hatonekoe.model

import tornadofx.ViewModel
import tornadofx.getProperty
import tornadofx.property

class TextDocumentModel(var textDocument: TextDocument): ViewModel() {
    val text = bind { textDocument.textProperty() }
}

class TextDocument(_text: String = "") {
    var text by property(_text)
    fun textProperty() = getProperty(TextDocument::text)
}
