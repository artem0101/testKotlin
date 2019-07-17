package fiveth

fun main() {
    createAllDoneRunnable().run()
    println(alphabet())
}

fun createAllDoneRunnable(): Runnable = Runnable { println("All done!") }

//fun alphabet() = with(StringBuilder()) {
//    for (letter in 'A'..'Z') this.append(letter)
//    append("\nNow I know the alphabet!")
//    toString()
//}

fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') this.append(letter)
    append("\nNow I know the alphabet!")
}.toString()