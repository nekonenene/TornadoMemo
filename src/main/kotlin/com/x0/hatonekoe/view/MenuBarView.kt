package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MenuBarController
import com.x0.hatonekoe.controller.TextAreaController
import tornadofx.*

class MenuBarView: View() {
    val menuBarController: MenuBarController by inject()
    val textAreaController: TextAreaController by inject()

    override val root = menubar {
        useMaxWidth = true
        paddingVertical = 3
        paddingHorizontal = 4

        menu("File") {
            menuitem("New")
            menuitem("Open")
            menuitem("Save")
            menu("Recent Files") {
                menuitem("File A")
                menuitem("File B")
                menuitem("File C")
            }
            menuitem("Quit") {
                setOnAction {
                    println("Pressed Quit!")
                }
            }
        }

        menu("Edit") {
            menuitem("Select All") {
                setOnAction {
                    println("Select!")
                    textAreaController.selectAll()
                }
            }
            menuitem("Copy")
            menuitem("Paste")
        }
    }
}
