package com.x0.hatonekoe.model

import com.x0.hatonekoe.TornadoMemoApp
import javafx.application.Application
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals

class TextModelTest {
    val textModel = ModelManager.textModel

    companion object {
        @BeforeClass @JvmStatic
        fun settings() {
            Thread {
                Application.launch(TornadoMemoApp::class.java, "")
            }.start()
        }
    }

    @Test
    fun charCounterTest() {
        var string = "abcde"
        textModel.textProperty.set(string)
        assertEquals(5, textModel.charCounter.value)

        string = "日本語"
        textModel.textProperty.set(string)
        assertEquals(3, textModel.charCounter.value)
    }

    @Test
    fun resetTest() {
        textModel.textProperty.set("abc")
        assertEquals(3, textModel.charCounter.value)

        textModel.reset()
        assertEquals("", textModel.text.value)
        assertEquals(0, textModel.charCounter.value)
    }
}
