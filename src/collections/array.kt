package collections

fun main() {
    val friends = arrayOf("Tintin", "Showy","Haddock", "Calculus")
    println(friends::class)
    println(friends.javaClass)
    println("${friends[0]} and ${friends[1]}")

    val numbers = intArrayOf(1,2,3)
    println(numbers::class)
    println(numbers.javaClass)


}