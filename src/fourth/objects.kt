package fourth

import java.io.File

// singletons
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}

//companion objects
class A {
    companion object {
        fun bar() = println("Companion object called")
    }
}

//class User3 private constructor(val nickname: String) {
//    lateinit var email: String
//
//
//    companion object {
//        fun newSubscribingUser(email: String) = User3(email.substringBefore('@'))
//        fun newFacebookUser(accoiuntId: Int) = User3(getFacebookName(accoiuntId))
//
//    }
//}

// objects-expression




fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    println()

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    println()

    A.bar()
}