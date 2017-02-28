package com.x0.hatonekoe.model

import com.x0.hatonekoe.view.TextAreaView
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

/**
 * text: textArea に表示されている文字列
 * charCountText: フッターに表示されている「Count: 6」などのカウンター文字列
 */
class TextDocumentModel: ViewModel() {
    val textProperty = SimpleStringProperty("")
    val charCounterTextProperty = SimpleStringProperty()

    val text = bind { textProperty }
    val charCounterText = bind { charCounterTextProperty }
}
