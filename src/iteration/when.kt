package iteration

import java.time.DayOfWeek

fun main() {
    fun isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = when {
        numberOfLiveNeighbors < 2 -> false
        numberOfLiveNeighbors > 3 -> false
        numberOfLiveNeighbors == 3 -> true
        else -> alive && numberOfLiveNeighbors == 2
    }

    fun printWhatToDo(dayOfWeek: Any) {
        when(dayOfWeek) {
            "Saturday", "Sunday" -> println("Relax")
            in listOf("Monday", "Tuesday", "Wednesday") -> println("Work hard")
            in 2..4 -> println("Work hard")
            "Friday" -> println("Party")
            is String -> println("What?")
        }
    }

    printWhatToDo("Sunday")
    printWhatToDo("Wednesday")
    printWhatToDo(3)
    printWhatToDo("Friday")
    printWhatToDo("Munday")

}