package lambdas

fun main() {
    val names = listOf("Pam", "Pat", "Paul", "Paula")
    println(names.find { name -> name.length == 5})
    println(names.find {name -> name.length == 4})

    fun predicatedOfLength(length: Int): (String) -> Boolean {
        return {input: String -> input.length == length}
    }

    println(names.find(predicatedOfLength(5)))
    println(names.find(predicatedOfLength(4)))

}