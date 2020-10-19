package internal

fun main() {
    val numbers = listOf(10,12,15,17,18,19)
    for(i in numbers) {
        if(i % 2 == 0) {
            print("$i, ")
        }
    }

    numbers.filter { e -> e % 2 == 0 }
            .forEach{e -> print("$e, ")}

    val doubled = mutableListOf<Int>()

    for(i in numbers) {
        if(i % 2 == 0) {
            doubled.add(i * 2)
        }
    }

    println(doubled)

    val doubledEven = numbers.filter { e -> e % 2== 0 }
            .map { e -> e * 2 }

    println(doubledEven)

    data class Person(val firstName: String, val age: Int)

    val people = listOf(
            Person("Sara", 12),
            Person("Jill", 51),
            Person("Paula", 23),
            Person("Paul", 25),
            Person("Mani", 12),
            Person("Jack", 70),
            Person("Sue", 10))

    val result = people.filter { person -> person.age > 20  }
            .map {person -> person.firstName  }
            .map { name -> name.toUpperCase() }
            .joinToString { ", " }

    val totalAge = people.map { person -> person.age  }
            .reduce{total, age -> total + age}

    println(totalAge)

    val totalAge2 = people.map {  person -> person.age  }
            .sum()

    println(totalAge2)

    val nameOfFirstAdult = people.filter {person -> person.age > 17  }
            .map {person -> person.firstName  }
            .first()

    println(nameOfFirstAdult)

    val families = listOf(
            listOf(Person("Jack", 40) , Person("Jill", 40)),
            listOf(Person("Eve", 18), Person("Adam", 18)))

    println(families.size)
    println(families.flatten().size)

    val namesAndReversed = people.map {person -> person.firstName  }
            .map(String :: toLowerCase)
            .map {name -> listOf(name, name.reversed())}
    println(namesAndReversed.size)

    val namesAndReversed2 = people.map { person -> person.firstName  }
            .map ( String :: toLowerCase )
            .map {name -> listOf(name, name.reversed())}
            .flatten()

    println(namesAndReversed2.size) // 14

    val namesAndReversed3 = people.map {person -> person.firstName  }
            .map(String :: toLowerCase)
            .flatMap { name -> listOf(name, name.reversed()) }
    println(namesAndReversed3)

    val namesSortedByAges = people.filter { person -> person.age > 17  }
            .sortedByDescending { person -> person.age }
            .map { person -> person.firstName  }


    println(namesSortedByAges)

    val groupBy1stLetter = people.groupBy { person -> person.firstName.first() }
    println(groupBy1stLetter)



    


}