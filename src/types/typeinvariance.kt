package types

fun main() {
    open class Fruit
    class Banana : Fruit()
    class Orange : Fruit()

    fun receiveFruits(fruits: List<Fruit>) {
        println("Number of fruits: ${fruits.size}")
    }

    val bananas: List<Banana> = listOf()
    receiveFruits(bananas)

    fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
        for(i in 0 until from.size) {
            to[i] = from[i]
        }
    }

    val fruitsBasket1 = Array<Fruit>(3) {_ -> Fruit()}
    val bananaBasket = Array<Banana>(3) {_ -> Banana()}

    copyFromTo(bananaBasket, fruitsBasket1)
    val things = Array<Any>(3) {_ -> Fruit()}
    copyFromTo(bananaBasket, things)

}

