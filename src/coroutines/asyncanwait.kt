package coroutines
import kotlinx.coroutines.*
fun main() {
    runBlocking {
        val count: Deferred<Int> = async(Dispatchers.Default) {
            println("fetching in ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }
        println("Called the function is ${Thread.currentThread()}")
        println("Number of cores is ${count.await()}")

    }
}