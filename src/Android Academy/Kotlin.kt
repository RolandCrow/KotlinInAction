package`Android Academy`

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


}


