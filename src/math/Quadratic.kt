package math

import java.lang.Math.sqrt

fun main() {
    /**
     * Пример
     *
     * Вычисление квадрата целого числа
     */
    fun sqr(x: Int) = x * x

    /**
     * Пример
     *
     * Вычисление квадрата вещественного числа
     */
    fun sqr(x: Double) = x * x

    /**
     * Пример
     *
     * Вычисление дискриминанта квадратного уравнения
     */
    fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c


    fun quadraticEquationRoot(a:Double, b: Double, c: Double) {
        (-b + kotlin.math.sqrt(discriminant(a, b, c))) / (2*a)
    }


    fun quadraticRootProduct(a: Double, b: Double, c:Double): Double {
        val sd = kotlin.math.sqrt(discriminant(a, b, c))
        val x1 = (-b + sd) / (2*a)
        val x2 = (-b - sd) / (2*a)
        return x1 * x2
    }

    fun solveQuadraticEquation(a: Double, b: Double, c:Double) {
        val sd = kotlin.math.sqrt(discriminant(a, b, c))
        val x1 = (-b + sd) / (2*a)
        val x2 = (-b - sd) / (2*a)

        println(x1)
        println(x2)

        println("x1 = $x1, x2 = $x2")
        println("x1 * x2 = ${x1 * x2}")

    }













}