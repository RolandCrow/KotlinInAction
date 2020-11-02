package types

import javax.naming.Context
import javax.print.attribute.Attribute
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

// p 117

