package fluency

fun main() {
    fun String.isPalindrome(): Boolean {
        return reversed() == this
    }

    fun String.shout() = toUpperCase()

    val str = "dad"
    println(str.isPalindrome())
    println(str.shout())


}