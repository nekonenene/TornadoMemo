package com.x0.hatonekoe

class FileHelper {
    /**
     * 与えられた path の拡張子を変更
     */
    fun changeExtension(originalFilePath: String, extension: String): String {
        val dotPosition = originalFilePath.lastIndexOf(".")

        val outputPath: String =
            if (dotPosition >= 0) {
                originalFilePath.substring(0, dotPosition + 1) + extension
            } else {
                originalFilePath + "." + extension
            }

        return outputPath
    }
}
