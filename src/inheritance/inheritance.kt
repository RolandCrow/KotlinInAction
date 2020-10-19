package inheritance

import java.lang.RuntimeException


fun main() {
    open class Vehicle(val year: Int, open var color: String) {
        open val km = 0
        final override fun toString() = "year: $year, Color: $color, KM: $km "
        fun repaint(newColor: String) {
            color = newColor
        }
    }

    open class Car(year: Int, color: String): Vehicle(year, color) {
        override var km: Int = 0
        set(value) {
            if(value < 1) {
                throw RuntimeException("can't set negative value")
            }
            field = value
        }
        fun drive(distance: Int) {
            km+=distance
        }
    }

    val car = Car(2019, "Orange")
    println(car.year)
    println(car.color)

    car.drive(10)
    println(car)

    try {
        car.drive(-30)
    } catch (ex: RuntimeException) {
        println(ex.message)
    }

    class FamilyCar(year: Int, color:String) : Car(year, color) {
        override var color: String
        get() = super.color
        set(value) {
            if(value.isEmpty()) {
                throw RuntimeException("Color required")
            }
            super.color = color
        }
    }

    val familyCar = FamilyCar(2019, "Green")
    println(familyCar.color)

    try {
        familyCar.repaint("")
    } catch (ex: RuntimeException) {
        println(ex.message)
    }

}