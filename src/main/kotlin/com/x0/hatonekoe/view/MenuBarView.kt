package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MenuBarController
import com.x0.hatonekoe.controller.TextAreaController
import javafx.application.Platform
import javafx.scene.input.KeyCombination
import tornadofx.*

class MenuBarView: View() {
    val menuBarController: MenuBarController by inject()
    val textAreaController: TextAreaController by inject()

    override val root = menubar {
        useMaxWidth = true
        paddingVertical = 3
        paddingHorizontal = 4

        menu("File") {
            item("New", KeyCombination.valueOf("Shortcut+N"))
            item("Open", KeyCombination.valueOf("Shortcut+O")) {
                setOnAction {
                    menuBarController.openFile()
                }
            }
            item("Save", KeyCombination.valueOf("Shortcut+S"))
            item("Save as new file", KeyCombination.valueOf("Shortcut+W"))
            item("Quit", KeyCombination.valueOf("Shortcut+Q")) {
                setOnAction {
                    Platform.exit()
                }
            }
        }

        menu("Edit") {
            item("Undo", KeyCombination.valueOf("Shortcut+Z")) {
                setOnAction {
                    textAreaController.undo()
                }
            }
            item("Redo", KeyCombination.valueOf("Shortcut+Shift+Z")) {
                setOnAction {
                    textAreaController.redo()
                }
            }

            separator()

            item("Select All", KeyCombination.valueOf("Shortcut+A")) {
                setOnAction {
                    textAreaController.selectAll()
                }
            }
            item("Copy", KeyCombination.valueOf("Shortcut+C")) {
                setOnAction {
                    textAreaController.copyText()
                }
            }
            item("Cut", KeyCombination.valueOf("Shortcut+X")) {
                setOnAction {
                    textAreaController.cutText()
                }
            }
            item("Paste", KeyCombination.valueOf("Shortcut+V")) {
                setOnAction {
                    textAreaController.pasteText()
                }
            }
        }
    }
}
