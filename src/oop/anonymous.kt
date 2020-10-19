package oop

fun main() {
    fun createRunnable(): Runnable {
        val runnable = object : Runnable {
            override fun run() {
                println("You called...")}
        }
        return runnable
    }

    val aRunnable = createRunnable()
    aRunnable.run()
}