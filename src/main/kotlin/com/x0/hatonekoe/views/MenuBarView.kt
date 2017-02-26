package com.x0.hatonekoe.views

import tornadofx.View
import tornadofx.menu
import tornadofx.menubar
import tornadofx.menuitem

class MenuBarView: View() {
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
            menuitem("Select All")
            menuitem("Copy")
            menuitem("Paste")
        }
    }
}
