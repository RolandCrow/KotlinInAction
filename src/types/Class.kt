package types

import javax.naming.Context
import javax.print.attribute.AttributeSet

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



}



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




// p 117

