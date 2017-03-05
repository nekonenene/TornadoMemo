package com.x0.hatonekoe.model

/** Manage all models */
object ModelManager {
    val textModel = TextModel()
    val fileModel = FileModel()

    fun reset() {
        textModel.reset()
        fileModel.reset()
    }
}
