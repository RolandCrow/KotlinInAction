package recursion

import kotlin.system.measureTimeMillis

fun main() {
    fun fib(n: Int) : Long = when(n) {
        0,1 -> 1L
        else -> fib(n - 1) + fib(n-2)
    }

    println(measureTimeMillis { fib(40) })
    println(measureTimeMillis { fib(45) })
}