package com.x0.hatonekoe.model

import com.x0.hatonekoe.view.TextAreaView
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

/**
 * text: textArea に表示されている文字列
 * charCountText: フッターに表示されている「Count: 6」などのカウンター文字列
 */
class TextDocumentModel: ViewModel() {
    val textAreaView: TextAreaView by inject()
    val textArea = textAreaView.root

    val textProperty = SimpleStringProperty("")
    val charCounterProperty = SimpleIntegerProperty(0)

    val text = bind { textProperty }
    val charCounter = bind { charCounterProperty }

    init {
        // bind bidirectional (textProperty <=> textArea)
        textProperty.bindBidirectional(textArea.textProperty())

        // when update text, then update charCounter
        textProperty.addListener({
            observableValue, oldValue, newValue ->
            charCounterProperty.set(newValue.length)
        })
    }
}
