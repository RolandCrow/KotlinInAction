package function

fun main() {

    fun getFullName() = Triple("John", "Quincy", "Adams")
    val (first, middle, last) = getFullName()
    println("$first $middle $last")
}