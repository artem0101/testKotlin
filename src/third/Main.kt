package third

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(2, 5, 91)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main() {
    println(set.max())

    println(list)

    println(list.joinToString("; ", "(", ")"))

    println(list.joinToString(separator = " ", prefix = " ", postfix = "."))

    println(list.joinToString(postfix = "&", prefix = "  "))

    println("Kotlin".lastChar())

    println(listOf("one", "two", "three").join(" "))

    val view: View = Button()
    view.click()

    val view1: View = Button()
    view1.showoff()

    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun String.lastChar(): Char = get(length - 1)

open class View {
    open fun click() = println("View clicked")
}

fun View.showoff() = println("i'm a view!")

open class Button : View() {
    override fun click() = println("Button clicked")
}

fun Button.showOff() = println("I'm a button!")

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) = this.setCharAt(length - 1, value)