package com.x0.hatonekoe.service

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
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

    @Test
    fun displayFileSizeTest() {
        assertEquals("3 Byte", FileService.displayFileSize(3))
        assertEquals("3 KB", FileService.displayFileSize(3_000))
        assertEquals("3 MB", FileService.displayFileSize(3_000_000))
        assertEquals("3 GB", FileService.displayFileSize(3_000_000_000))
        assertEquals("3000 GB", FileService.displayFileSize(3_000_000_000_000))
        assertEquals("1234 GB", FileService.displayFileSize(1_234_567_890_000))
    }
}
