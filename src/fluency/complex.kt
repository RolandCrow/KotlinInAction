package fluency

import kotlin.math.abs

fun main() {
    data class Complex(val real: Int, val imaginary: Int) {
        operator fun times(other: Complex) =
                Complex(real * other.real - imaginary * other.imaginary,
                        real * other.imaginary + imaginary * other.real)

        private fun sign() = if(imaginary < 0) "-" else "+"
        override fun toString() = "$real ${sign()} ${abs(imaginary)}i"
    }

    println(Complex(4,2) * Complex(-3,4))
    println(Complex(1,2) * Complex(-3,4))


}
