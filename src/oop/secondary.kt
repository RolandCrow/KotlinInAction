package oop

import java.lang.RuntimeException

fun main() {
    class Person(val first: String, val last: String) {
        var fulltime = true
        var location: String = "-"

        constructor(first:String, last: String, fte: Boolean) : this(first, last) {
            fulltime = fte
        }

        constructor(first:String, last: String, loc: String) : this(first, last, false) {
            location = loc
        }

        override fun toString(): String = "$first $last $location"

        internal fun fullName() = "$last, $first"
        private fun yearsOfService(): Int =
                throw RuntimeException("Not implemented yet")
    }

    println(Person("Jane", "Doe"))
    println(Person("Jone", "Doe"))
    println(Person("Baby", "Doe", false))
}
