package com.x0.hatonekoe

import com.x0.hatonekoe.service.FileHelper
import org.junit.Test
import kotlin.test.assertEquals

class FileHelperTest {
    private val fileHelper = FileHelper()

    @Test
    fun changeExtensionTest() {
        assertEquals("test.jpg", fileHelper.changeExtension("test.png", "jpg"))
        assertEquals("../../test.test.png", fileHelper.changeExtension("../../test.test.jpg", "png"))
    }
}
