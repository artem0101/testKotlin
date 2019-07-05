package fiveth

var list = listOf(1, 2, 3, 4)
var people = listOf(Person("Alice", 23), Person("Bob", 32))
var map = list.map { it * it }
var numbers = mapOf(0 to "zero", 1 to "one")
var canBeInClub = { p: Person -> p.age <= 27}

fun main() {
    println(list.filter { it % 2 == 0 })
    println("\n${people.filter { it.age > 30 }}")
    println("\n$map")
    println("\n${people.map { it.name }}")
    println("\n${people.filter { it.age > 30 }.map { it.name }}")
    println("\n${people.filter { it.age == people.maxBy(Person::age)?.age }}")
    println("\n${numbers.mapValues { it.value.toUpperCase() }}")
    println("\n${people.all(canBeInClub)}")
    println("\n${people.any(canBeInClub)}")
    println("\n${!list.all { it == 3 }}\n${list.any { it != 3 }}")
    println("\n${people.count(canBeInClub)}")
}