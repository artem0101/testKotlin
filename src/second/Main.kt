package second

import java.io.BufferedReader
import java.io.StringReader
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.*
import third.lastChar as last


fun main(args: Array<String>) {
    println("second.getWarmth(second.Color.YELLOW): ${getWarmth(Color.YELLOW)}")
    println("second.getMnemonic(second.Color.RED): ${getMnemonic(Color.RED)}")
    println("second.mix(second.Color.YELLOW, second.Color.BLUE): ${mix(Color.YELLOW, Color.BLUE)}")
    println("second.mixOptimized(second.Color.BLUE, second.Color.YELLOW): ${mixOptimized(Color.BLUE, Color.YELLOW)}")
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))

    for (i in 1 .. 100) print(fizzBuzz(i) + " ")
    println()
    for (i in 100 downTo 1 step 2) print(fizzBuzz(i) + " ")
    println()

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') binaryReps[c] = Integer.toBinaryString(c.toInt())

    for ((letter, binary) in binaryReps) println("$letter = $binary")

    println(isLetter('q'))

    println(isNotDigits('1'))

    println(recognize('9'))

    val reader = BufferedReader(StringReader("234"))
    println(readNumber(reader))
//    println(readNumber(BufferedReader(StringReader("It isn't number("))))

    println("Kotlin".last())

}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Каждый"
        Color.ORANGE -> "Охотник"
        Color.YELLOW -> "Желает"
        Color.GREEN -> "Знать"
        Color.BLUE -> "Где"
        Color.INDIGO -> "Сидит"
        Color.VIOLET -> "Фазан"
    }

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "тёплый"
    Color.GREEN -> "нейтральный"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "холодный"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Грязный цвет")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.YELLOW && c2 == Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Грязный цвет")
    }

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Expr.Sum -> {
            val left = eval(e.left)
            val right = eval(e.right)
            println("sum: ${left + right}")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A' .. 'Z'

fun isNotDigits(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "$c - It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "$c - It's a letter."
    else -> "Unknown..."
}

fun readNumber(reader: BufferedReader): Int? {
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NullPointerException) {
        null
    } finally {
        reader.close()
    }
}