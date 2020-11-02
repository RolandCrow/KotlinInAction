package function

import com.sun.tools.classfile.Module_attribute.ProvidesEntry.length
import java.awt.Color
import java.awt.Color.*
import java.io.BufferedReader
import java.io.Serializable
import java.io.StringReader
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.lang.reflect.Array.get
import java.util.*
import javax.naming.Context
import javax.swing.JToolBar

fun main() {
    fun max(numbers: IntArray): Int {
        var large = Int.MIN_VALUE
        for (number in numbers) {
            large = if (number > large) number else large
        }
        return large
    }


    println(max(intArrayOf(1, 5, 2, 12, 7, 3)))


    fun greet(name: String, msg: String = "Hello") = "$msg $name"
    println(greet("Eve"))
    println(greet("Eve", "Howdy"))

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    println(max(1, 2))

    fun hello(args: Array<String>) {
        if (args.isNotEmpty()) {
            println("Hello, ${args[0]}")
        }
    }

    fun getWarmth(color: Color) = when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "Теплый"
        Color.BLUE, Color.GRAY, Color.white -> "Холодный"
        else -> "Нейтральный"
    }

    println(getWarmth(Color.ORANGE))


    fun mix(c1: Color, c2: Color) {
        when (setOf(c1, c2)) {
            setOf(RED, BLUE) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, CYAN) -> MAGENTA
            else -> throw Exception("Грязный цвет")
        }
    }

    fun mixOptimized(c1: Color, c2: Color) = when {
        (c1 == RED && c2 == BLUE) || (c1 == BLUE && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == CYAN) || (c1 == CYAN && c2 == BLUE) -> MAGENTA
        else -> throw Exception("Dirty Color")
    }
    println(mixOptimized(BLUE, YELLOW))


    fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "Fizz Buzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }

    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    } // пара ключ значение букве присваивается ее двоичное выражение

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }


    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'

    println(isLetter('q'))
    println(isNotDigit('a'))




    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's digit"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter "
        else -> "I don't know"


    }

    println(recognize('8'))

    fun readNumber(reader: BufferedReader): Int? {
        return try {
            val line = reader.readLine()
            Integer.parseInt(line)
        } catch (e: NumberFormatException) {
            null
        } finally {
            reader.close()
        }
    }

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    fun <T> Collection<T>.joinToString(
            separator: String = ", ",
            prefix: String = "",
            postfix: String = ""
    ): String {
        val result = StringBuilder(prefix)

        for((index,element ) in this.withIndex()) {
            if(index > 0) result.append(separator)
        result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    val list = listOf(1,2,3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = "; "))

    open class View {
        open fun click() = println("View clicked")
    }

    class Button: View() {
        override fun click() {
            println("Button clicked")
        }
    }

    val view: View = Button()
    view.click()


    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    infix fun Any.to(other: Any) = Pair(this, other)
    val (number, name) = 1 to "one"






   }

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if(b) "got" else "lost"} focus.")
    }

    fun showOff() = println("I'm focusable")
}



class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}



open class RichButton: Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {
    }

}


abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

interface State: Serializable

/* interface View {
    fun getCurrentState(): State
    fun restoreState(): State
} */

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when(e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
        }

























