package types

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.io.BufferedReader
import java.io.File.separator
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.time.LocalDate
import javax.naming.Context
import javax.print.attribute.AttributeSet
import javax.sql.rowset.Predicate
import javax.swing.text.html.parser.Entity
import kotlin.reflect.KProperty

open class View {
    constructor(ctx: Context) {

    }
    constructor(ctx: Context, attr: AttributeSet) {

    }


}

class MyButton: View {
    constructor(ctx: Context): super(ctx) {}
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr)
}

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User

class SubcribingUser(private val email: String) : User {
    override val nickname: String
    get() = email.substringBefore('@')
}

class User1(private val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent())
        field = value
    }

}

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter+= word.length
    }
}

class Client(private val name : String, private val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode

    }

    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
    override fun hashCode(): Int  = name.hashCode() * 31 + postalCode
}

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>())
    :Collection<T> by innerList {

}

class CountingSet<T>(
        private val innerSet: MutableCollection<T> = HashSet<T>()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }


}

data class Person(val name: String, val age: Int? = null) {
    object NameComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1?.name?.compareTo(p2.name)


    }

    fun isOlderThan(other: Person): Boolean? {
        if(age == null || other.age == null)
            return null
        return age > other.age
    }


}

class Book(val title: String, val authors: List<String>) {

}


class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int,
                val city: String, val country: String)


class Company(val name: String, val address: Address?)

class Person1(val name: String, val company: Company?)


fun Person1.countryName(): String {
    return company?.address?.country ?: "Unknown"
}

fun printShippingLabel(person1: Person1) {
    val address = person1.company?.address
            ?: throw IllegalAccessException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode, $city, $country")
    }
}
fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0,100)
    println("We're ${percent}% done")
}


data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point { // перегрузка операторов
        return Point(x + other.x, y + other.y)
    }

}


operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y* scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}



class Point1(val x: Int, val y: Int) {
    override fun equals(obj: Any?): Boolean {
        if(obj === this) return true
        if(obj !is Point) return false
        return obj.x == x && obj.y == y
    }


}

class Person2(
        private val firstName: String, private val lastName: String
): Comparable<Person2> {
    override fun compareTo(other: Person2): Int {
        return compareValuesBy(this, other, Person2::lastName, Person2::firstName)
    }
}

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw  IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(var upperLeft: Point1, var lowerRight: Point1)


operator fun Rectangle.contains(p: Point1): Boolean {
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext()  = current <= endInclusive

            override fun next() = current.apply {
                current = plusDays(1)
            }

        }


fun printEntries(map: Map<String, String>) {
    for((key , value) in map) {
        println("$key -> $value")
    }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }

}

class ObservableProperty(
        var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Person3, prop: KProperty<*>) : Int = propValue

    operator fun setValue(p: Person3,prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

}

/* class Person3(val name: String, age: Int, salary: Int): PropertyChangeAware() {


    var age: Int = age
    set(newValue) {
        val oldValue = field
        field = newValue
        changeSupport.firePropertyChange(
                "age", oldValue, newValue
        )
    }

    var salary: Int = salary
    set(newValue) {
        val oldValue = field
        field = newValue
        changeSupport.firePropertyChange(
                "salary", oldValue, newValue
        )
    }
    }*/


class Person3(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    val age: Int by ObservableProperty(age, changeSupport)
    val salary: Int by ObservableProperty(salary, changeSupport)
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2,3)
    println("The result is $result")
}


fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for(index in 0 until length) {
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return  sb.toString()
    }

/* fun <T> Collection<T>.joinToString (
    separator: String = ",",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = {it.toString()}
    ): String {
        val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()



}

*/

fun <T> Collection<T>.joinToString (
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> String)? = null
):String {
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()) {
        if(index > 0) result.append(separator)
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)

    }
    result.append(postfix)
    return result.toString()

}


enum class Delivery {STANDARD, EXPEDITED}

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double
    {
        if (delivery == Delivery.EXPEDITED) {
            return {order -> 6 + 2.1 * order.itemCount  }
        }
        return {order -> 1.2 * order.itemCount  }
    }




// p 256









// p



fun main() {

    class Person (
            val name: String,
            var isMerried: Boolean
    )

    val person  = Person("Bob", true )
    println(person.name)
    println(person.isMerried)


    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
            get() {
                return height == width
            }
    }

    val rectangle = Rectangle(41,42)
    println(rectangle.isSquare)



    println(PrivateUser("test@Kotlinlang.org").nickname)
    println(SubcribingUser("test@Kotlinlang.org").nickname)


    val user1 = User1("Alice")
    user1.address = "Elsenheimerstrasse 47, 80687 Muenchen"


    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)


    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} object were added, ${cset.size} remain")




    val sum = {x: Int, y: Int -> x + y}
    println(sum(1,2))

    val sum1 = {x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum1(1,2))

    fun printMessagesWithPrefix(message: Collection<String>, prefix: String) {
        message.forEach {
            println("$prefix $it")
        }
    }

    fun printProblemsCounts(responses: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0

        responses.forEach {
            if(it.startsWith("4")) {
                clientErrors++
            } else if(it.startsWith("5")) {
                serverErrors++
            }
        }
        println("$clientErrors client errors, $serverErrors server errors")
    }

    val responses = listOf("200OK", "418 I'm a teapot", "500 Internal Server Error")
    println(printProblemsCounts(responses))

    val list = listOf(1,2,3,4)
    println(list.filter { it % 2 == 0})
    println(list.map { it * it })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.map { it.name })
    people.filter { it.age!! > 30 }
    // p 152


    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
            Book("Mort", listOf("Terry Pratchett")),
            Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

    println(books.flatMap { it.authors }.toSet())


    people.asSequence().map(types.Person :: name).filter { it.startsWith("A") }.toList()


    listOf(1,2,3,4).asSequence().map{ println("map($it)"); it * it}
            .filter { print("filter($it)"); it % 2 == 0 }
            .toList()

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100}
    println(numbersTo100.sum())

    fun alphabet(): String {
        val stringBuilder = StringBuilder()
        return with(stringBuilder) {
            for(letter in 'A'..'Z') {
                this.append(letter)
            }
            append("\nNow I know the alphabet!")
            this.toString()
        }

    }

    fun alphabet1() = StringBuilder().apply {
        for(letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }.toString()



    fun printAllCaps(s: String?) {
        val allCaps: String? = s?.toUpperCase()
        println(allCaps)
    }


    val ceo = Employee("Da Boss!", null)
    val developer = Employee("Bob Smith", ceo)

    println(managerName(developer))
    println(managerName(ceo))

    fun foo(s: String) {
        val t: String = s ?: ""
    }

    fun strLenSafe(s: String?): Int = s?.length ?: 0

    println(Person("Sam", 35).isOlderThan(types.Person("Amy", 42)))


// p 205


    fun readNumbers(reader: BufferedReader): List<Int?> {
        val result = ArrayList<Int?>()
        for(line in reader.lineSequence()) {
            try {
                val number = line.toInt()
                result.add(number)
            }
            catch (e: NumberFormatException) {
                result.add(null)
            }

        }
        return result
    }

    fun addValidNumbers(numbers: List<Int?>) {
        var sumOfValidNumbers = 0
        var invalidNumbers = 0

        for(number in numbers) {
            if(number != null) {
                sumOfValidNumbers += number
            } else {
                invalidNumbers++
            }
        }
        println("Sum of valid numbers: $sumOfValidNumbers")
        println("Invalid numbers: $invalidNumbers")
    }

    fun addValidNumbers1(numbers: List<Int?>) {
        val validNumbers = numbers.filterNotNull()
        println("Sum of valid numbers: ${validNumbers.sum()}")
        println("Invalid numbers: ${numbers.size - validNumbers.size}")
    }

    fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
        for(item in source) {
            target.add(item)
        }
    }

    val source: Collection<Int> = arrayListOf(3,5,7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)

    val letters = Array<String>(26) {i -> ('a' + i).toString()}
    println(letters.joinToString { "" })

// p 220


    val p1 = Point(10,20)
    val p2 = Point(30, 40)
    println(p1 + p2)


    val p = Point(10,20)
    println(p * 1.5)

    println('a' * 3)

    twoAndThree{ a,b -> a + b}
    twoAndThree{a,b -> a * b}

    println("ab1c".filter { it in 'a'..'z' })



    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")






}
