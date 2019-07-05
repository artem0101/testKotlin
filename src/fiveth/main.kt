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
}

fun sendEmail(person: Person, message: String): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}




