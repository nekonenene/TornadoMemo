package com.x0.hatonekoe.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

class TextDocumentModel(var textDocument: TextDocument): ViewModel() {
    val text = bind { textDocument.textProperty }
    val charCounterText = bind { textDocument.charCounterTextProperty }
}

class TextDocument {
    val textProperty = SimpleStringProperty()
    val charCounterTextProperty = SimpleStringProperty()
}
