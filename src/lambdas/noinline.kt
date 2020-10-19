package lambdas

import java.lang.RuntimeException


    inline fun invokeTwo(
            n: Int,
            action1: (Int) -> Unit,
            action2: (Int) -> Unit
    ): (Int) -> Unit  {
        println("enter invokeTwo $n")
        action1(n)
        action2(n)

        println("exit invokeTwo $n")
        return{_: Int -> println("lambda returned from invokeTwo")}
    }

    fun report(n: Int) {
        println("")
        print("called with $n, ")
        val stackTrace = RuntimeException().stackTrace
        println("Stack depth: ${stackTrace.size}")
        println("Partial listing of the stack:")
        stackTrace.take(3).forEach(::println)
    }

    fun callInvokeTwo() {
        invokeTwo(1, {i -> report(i)}, {i -> report(i)} )
    }

fun main() {
    callInvokeTwo()
}


