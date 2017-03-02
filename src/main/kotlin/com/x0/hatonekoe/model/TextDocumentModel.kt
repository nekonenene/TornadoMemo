package com.x0.hatonekoe.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

/**
 * text: textArea に表示されている文字列
 * charCountText: フッターに表示されている「Count: 6」などのカウンター文字列
 */
class TextDocumentModel: ViewModel() {
    val textProperty = SimpleStringProperty("")
    val charCounterProperty = SimpleIntegerProperty(0)

    val text = bind { textProperty }
    val charCounter = bind { charCounterProperty }

    init {
        // when update text, then update charCounter
        textProperty.addListener({
            observableValue, oldValue, newValue ->
            charCounterProperty.set(newValue.length)
        })
    }
}
