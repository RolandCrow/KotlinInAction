package types

fun main() {
    class Animal(val age: Int) {
        override operator fun equals(other: Any?): Boolean {
            return if(other is Animal) age == other.age else false
        }
    }

    val greet: Any = "hello"
    val odie: Any = Animal(2)
    val toto: Any = Animal(2)
    val butch = Animal(3)
    println(odie == butch) // false
    println(odie == toto)// true

}