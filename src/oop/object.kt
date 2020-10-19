package oop

fun main() {
    fun drawCircle() {
        val circle = object {
            val x = 10
            val y = 20
            val radius = 30
        }
        println("Circle x: ${circle.x} y: ${circle.y} radius: ${circle.radius}")
    }
}