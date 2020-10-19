package oop

import javax.print.attribute.standard.OutputDeviceAssigned

fun main() {
    data class Task(val id: Int, val name: String, val completed: Boolean,
    val assigned: Boolean)

    val task1 = Task(1, "Create Project", false, true)
    println("Name: ${task1.name}")

    val(id, _, _, isAssigned) = task1
    println("Id: $id Assigned: $isAssigned")
}