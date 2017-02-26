package com.x0.hatonekoe

import javafx.beans.property.SimpleStringProperty

class TextManager {
    var text = ""
    var footerCounterText = SimpleStringProperty()

    fun update() {
        val charCount = text.length
        footerCounterText.set("Count: $charCount")
    }
}
