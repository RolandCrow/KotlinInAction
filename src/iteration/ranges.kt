package iteration

fun main() {
    val oneToFive: IntRange = 1..5
    val aToE: CharRange = 'a'..'e'
    val seekHelp: ClosedRange<String> = "hell".."help"

    for (i in 5 downTo 1) {print("$i,")}
    for (i in 1 until 5) {print("$i, ") } // не достигая
    for (i in 1 until 10 step 3) {print("$i, ")} // шаг 3

    for(i in (1..9).filter { it % 3 == 0 || it % 5 == 0 }) {
        print("$i, ") // делятся на 3 или на 5
    }

    val array = arrayOf(1,2,3)
    println(array.javaClass)

    val list = listOf(1,2,3)
    println(list.javaClass)
    for(e in list) { print("$e, ")}




}