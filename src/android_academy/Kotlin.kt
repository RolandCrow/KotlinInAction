package android_academy

import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    var a: String? = null
    var b: String

    var c: String? = null
    var bLength = c!!.length // явное указание на налл

    val d: String? = null
    val dLength: Int = d?.length ?: 0 // если все норм то выполняется левая часть от ?, если налл
    // то правая часть

    when (1) {
        1 -> print("x==1")
        2 -> print("x==2")
        else -> {
            print("x is neither 1 or 2")
        }
    }

    val names = arrayOf("Sergei", "Pasha", "Artur")

    for (name in names) { // перечисление каждого
        println(name)
    }

    for ((index, value) in names.withIndex()) {
        println("Cell #$index: name in $value")
    }

    fun greeting(name: String = "Android", age: Int, phone: String): String {
        return "Hello$name" + "your age $age"
    }

    greeting("Dime", 39, "555")
    greeting(age = 19, name = "Sasha", phone = "444")

    val names1 = arrayOf("Sergei", "Pasha", "Artur", "Alisha")
    println(names1.filter { names1 -> names1[0] == 'A' })

    val sayHello = { println("Hello Android Academy") }
    sayHello() // вызвали как функцию

    val currentStudents = 100
    val growth: (Int) -> Int = { students -> students * 2 }
    println("new students count is" + growth(currentStudents))

    fun <T> List<T>.forEach(loop: (T) -> Unit) {
        for (element in this) {
            loop(element)
        }
    }

    fun sqr(x: Int) = x * x
    fun sqr(x: Double) = x * x
    fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

    fun max(m: Int, n: Int) = if(m > n) m else n

    fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
        val d = discriminant(a,b,c)
      //  return if(d> 0.0) 2 else if(d == 0.0) 1 else 0

        return when {
            d > 0.0 -> 2
            d == 0.0 -> 1
            else -> 0
        }


    }

    fun gradeNotation(grade: Int): String = when (grade) {
        5 -> "отлично"
        4 -> "хорошо"
        3 -> "удовлетворительно"
        2 -> "неудовлетворительно"
        else -> "несуществующая оценка $grade"
    }

    fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
            sqr(x - x0) + (y - y0) <= sqr(r)

    val x = 0.5
    val y = 0.5

    if(pointInsideCircle(x, y, 0.0, 0.0, 1.0) && pointInsideCircle(x, y, 1.0, 1.0, 1.0)) {}

    if(pointInsideCircle(x, y, 0.0, 0.0, 1.0) || pointInsideCircle(x, y, 1.0, 1.0, 1.0)) {}

    if(!pointInsideCircle(x,y, 0.0, 0.0, 1.0)) {}

    fun minBigRoot(a: Double, b: Double, c: Double): Double {
        if(a == 0.0) {
            if(b == 0.1) return Double.NaN
            val bc = -c/b
            if(bc < 0.0) return Double.NaN
            return -sqrt(bc)

        }

        val d = discriminant(a,b,c)
        if(d < 0.0) return Double.NaN

        val y1 = (-b + sqrt(d)) / (2 * a)
        val y2 = (-b -  sqrt(d)) / (2 * a)

        val y3 = max(y1, y2)
        if(y3 < 0.0) return Double.NaN
        return -sqrt(y3)


    }
















}


