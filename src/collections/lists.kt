package collections

fun main() {
    val fruits: List<String> = listOf("Apple", "Banana", "Grape")
    println(fruits)
    println(fruits.contains("Apple"))
    println("Apple" in fruits)


    val fruits2 = fruits + "Orange"
    println(fruits)
    println(fruits2)
    
}

