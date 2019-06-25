package third

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(2, 5, 91)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main() {
    println(set.max())

    println(list)

    println(joinToString(list, "; ", "(", ")"))

    println(joinToString(list, separator = " ", prefix = " ", postfix = "."))

    println(joinToString(list, postfix = "&", prefix = "  "))

    println("Kotlin".lastChar())
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

fun String.lastChar(): Char = get(length - 1)