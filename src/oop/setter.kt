package oop

import java.lang.Exception
import java.lang.RuntimeException

fun main() {
    class Car(val yearOfMake: Int, theColor: String) {
        var fuelLevel = 100

        var color = theColor
        set(value) {
            if(value.isBlank()) {
                throw RuntimeException("no, empty please")
            }
            field = value
        }
        init {
            if(yearOfMake < 2020) {fuelLevel = 90 }
        }
    }

    val car = Car(2019, "Red")
    car.color = "Green"
    car.fuelLevel--
    println(car.fuelLevel)

    try {
        car.color = ""
    } catch (ex: Exception) {
        println(ex.message)
    }
    println(car.color)
}