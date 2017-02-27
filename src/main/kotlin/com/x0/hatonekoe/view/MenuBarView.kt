package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MenuBarController
import com.x0.hatonekoe.controller.TextAreaController
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
            menuitem("New", KeyCombination.valueOf("Shortcut+N"))
            menuitem("Open", KeyCombination.valueOf("Shortcut+O"))
            menuitem("Save", KeyCombination.valueOf("Shortcut+S"))
            menuitem("Quit", KeyCombination.valueOf("Shortcut+Q")) {
                setOnAction {
                    println("Pressed Quit!")
                }
            }
        }

        menu("Edit") {
            menuitem("Select All", KeyCombination.valueOf("Shortcut+A"))
                .setOnAction {
                    println("Select!")
                    textAreaController.selectAll()
                }
            menuitem("Copy", KeyCombination.valueOf("Shortcut+C"))
                .setOnAction {
                    textAreaController.copyText()
                    textAreaController.updateTextDocModel()
                }
            menuitem("Cut", KeyCombination.valueOf("Shortcut+X"))
                .setOnAction {
                    textAreaController.cutText()
                    textAreaController.updateTextDocModel()
                }
            menuitem("Paste", KeyCombination.valueOf("Shortcut+V"))
                .setOnAction {
                    textAreaController.pasteText()
                    textAreaController.updateTextDocModel()
                }
        }

        menu("Test") {
            menuitem("Item1") {
                // この setOnAction の書き方だと、１度目に押されたときに反応しない。バグ？
                setOnAction {
                    println("Item1 pushed!")
                }
            }
        }
    }
}
