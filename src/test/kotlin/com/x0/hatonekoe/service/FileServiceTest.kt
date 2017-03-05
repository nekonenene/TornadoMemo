package com.x0.hatonekoe.service

import org.junit.Test
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FileServiceTest {
    @Test
    fun isTextFileTest() {
        val textFile: File = File(javaClass.classLoader.getResource("test01.txt").file)
        val rtfFile: File = File(javaClass.classLoader.getResource("test01.rtf").file)

        assertTrue(FileService.isTextFile(textFile))
        assertFalse(FileService.isTextFile(rtfFile))
    }
}
