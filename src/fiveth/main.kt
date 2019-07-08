package fiveth

data class Person(val name: String, val age: Int) {

}

val createPerson = ::Person
val p = createPerson("Kate", 20)

fun Person.isAudit() = age >= 21
val predicate = Person::isAudit

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        when {
            it.startsWith("4") -> clientErrors++
            it.startsWith("5") -> serverErrors++
        }
    }
    println("$clientErrors - client errors\n$serverErrors - server errors")
}

class Book(val title: String, val authors: List<String>)

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)
    println(people.maxBy { it.age })
    println()
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
//    run { println(42) }
    println()
    val names = people.joinToString(separator = " ", transform = { it.name })
    println(names)

    println()
    val sum1 = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum1(2, 5))

    println()
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")

    println()

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    fun hell() = println("Hell")

    run(::hell)

    val action = { person: Person, message: String -> sendEmail(person, message) }

    println("\n$p")

    val nat = Person("Elena", 18)
    println("\n${nat.isAudit()} ")

    val people1 = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
    println(people1.groupBy { it.age })

    val list1 = listOf("a", "ab", "b")
    println(list1.groupBy(String::first))

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")), Book("Mort", listOf("Terry Pratchett")),
        Book("God Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )
    println("\n${books.flatMap { it.authors }.toSet()}")

    val strings = listOf("abc", "def")
    println("\n${strings.flatMap { it.toList() }}")

    listOf(1, 2, 3, 4).asSequence().map { print("map($it) "); it * it }.filter { print("filter($it) "); it % 2 == 0 }
        .toList()

    println("\n${listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 }}")

    val people2 = listOf(Person("Alice", 29), Person("Bob", 31), Person("Charles", 31), Person("Dan", 21))
    println("\n${people2.asSequence().map { it.name }.filter { it.length < 4 }.toList()}")
    println("\n${people2.asSequence().filter { it.name.length < 4 }.map { it.name }.toList() }")

}

fun sendEmail(person: Person, message: String): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}




