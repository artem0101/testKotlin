package fourth

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${ if (b) "got" else "lost" }")
    fun showOff() = println("I'm focusable!")
}

class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}


interface User1 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val nickname: String, override val email: String): User1

class SubscribingUser(override val email: String): User1 {
    override val nickname: String
        get() = email.substringBefore('@')
}

//abstract class FaceBookUser(val accountId: Int): User1 {
//    override val nickname: String = getFacebookName(accountId)
//
//    private fun getFacebookName(accountId: Int): String {
//
//    }
//}


class User2(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value".
        """.trimIndent())
    }
}

class LengthCounter {
    var counter: Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}


fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()

    println()

    val user = User2("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    println()

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

