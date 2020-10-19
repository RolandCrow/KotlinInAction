package recursion

import kotlin.system.measureTimeMillis

fun main() {
    fun<T, R> ((T) -> R).memoize(): ((T) -> R) {
        val original = this
        val cache = mutableMapOf<T,R>()
        return {n: T -> cache.getOrPut(n) {original(n)} }
    }

    lateinit var fib: (Int) -> Long

    fib = {n:Int ->
        when(n) {
            0,1 -> 1L
            else -> fib(n-1) + fib(n-2)
        }

    }.memoize()

    println(measureTimeMillis { fib(40) }) // 0
    println(measureTimeMillis { fib(45) }) // 0
    println(measureTimeMillis { fib(500) }) // 1
}