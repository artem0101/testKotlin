package fourth

import third.Button
import javax.naming.Context
import javax.print.attribute.AttributeSet

class User(val nickname: String, val isSubscribed: Boolean = true) {

}

class RadioButton: Button()

class Secretive private constructor()

open class View1 {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: AttributeSet) {

    }


}

class MyButton: View1 {
    constructor(ctx: Context): super(ctx) {

    }

    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr) {

    }
}

fun main() {
    val alice = User("Alice")
    val bob = User("Bob", false)
    val carol = User("Carol", isSubscribed = false)

    println("${alice.nickname}: ${alice.isSubscribed}\n${bob.nickname}: ${bob.isSubscribed}\n${carol.nickname}: ${carol.isSubscribed}")
}