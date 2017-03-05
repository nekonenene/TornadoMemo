package com.x0.hatonekoe.controller

import com.x0.hatonekoe.TornadoMemoApp
import com.x0.hatonekoe.model.ModelManager
import javafx.application.Application
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals

class TextAreaControllerTest {
    val textAreaController = TextAreaController()

    companion object {
        @BeforeClass @JvmStatic
        fun settings() {
            Thread {
                Application.launch(TornadoMemoApp::class.java, "")
            }.start()
        }
    }

    @Test
    fun setTextTest() {
        val string = "test!"
        textAreaController.setText(string)
        assertEquals(string, textAreaController.textArea.text)
    }

    @Test
    fun bindTest() {
        val string = "abc"
        ModelManager.textModel.textProperty.set(string)
        assertEquals(string, textAreaController.textArea.text)

        ModelManager.textModel.reset()
        assertEquals("", textAreaController.textArea.text)
    }
}
