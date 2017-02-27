package com.x0.hatonekoe.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

/**
 * text: textArea に表示されている文字列
 * charCountText: フッターに表示されている「Count: 6」などのカウンター文字列
 */
class TextDocumentModel(var textDocument: TextDocument): ViewModel() {
    val text = bind { textDocument.textProperty }
    val charCounterText = bind { textDocument.charCounterTextProperty }
}

class TextDocument {
    val textProperty = SimpleStringProperty()
    val charCounterTextProperty = SimpleStringProperty()
}
