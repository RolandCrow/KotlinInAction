package collections

import javax.swing.text.html.HTML.Tag.S


fun main() {
    val friends = arrayOf("Tintin", "Showy","Haddock", "Calculus")
    println(friends::class)
    println(friends.javaClass)
    println("${friends[0]} and ${friends[1]}")

    val numbers = intArrayOf(1,2,3)
    println(numbers::class)
    println(numbers.javaClass)

    val myList = ArrayList<String>()
    myList.add("Donald Knutch")
    myList.add("Rasmus Lerdorf")
    myList.add(1, "Richard Stallman")

    if(myList.isEmpty()) {

    } else {
        
    }

    val numItems = myList.size
    val position = myList.indexOf("Richard Stallman")

    for( s in myList) {
       
    }

}