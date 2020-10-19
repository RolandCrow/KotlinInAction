package inheritance

fun main() {
    class TV{
        private var volume = 0
        val remote: Remote
        get() = TVRemote()

        override fun toString(): String = "Volume: ${volume}"

        inner class TVRemote: Remote {
            override fun up() {volume++}
            override fun down() {volume--}

            override fun toString() = "Remote: ${this@TV.toString()}"
        }
    }

    val tv = TV()
    val remote = tv.remote

    println("$tv")
    remote.up()
    println("After increasing: $tv")
    remote.doubleUp()
    println("After doubleUp: $tv")

}