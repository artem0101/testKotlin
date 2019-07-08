package fiveth

import java.io.File

val naturalNumbers = generateSequence(0) { it +1 }
val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }


fun main() {
    println(numbersTo100.sum())

    val file = File("/home/artem/.wine/user.reg")
    println("\n${ file.isInsideHiddenDirectory() }")
}

