package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import tornadofx.View
import tornadofx.menu
import tornadofx.menubar
import tornadofx.menuitem

class MenuBarView: View() {
    val mainController: MainController by inject()

    override val root = menubar {
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
                    mainController.selectAll()
                }
            }
            menuitem("Copy")
            menuitem("Paste")
        }
    }
}
