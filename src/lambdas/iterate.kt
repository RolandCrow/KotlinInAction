package lambdas

fun main() {
    fun walk1to(n: Int, action: (Int) -> Unit) =
            (1..n).forEach {action(it)
    }

    walk1to(5) {i -> print(i)}
}