package iteration

fun main() {
    val names = listOf("Tom", "Jerry", "Spike")
    for(index in names.indices) {
        println("Position of ${names[index]} is $index")
    }



}