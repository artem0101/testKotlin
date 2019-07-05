package fourth

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {}
}

class NewButton1 : RichButton() {
    //    override fun disable() {}
    override fun animate() {}
//    override fun click() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

class NewAnimated1 : Animated() {
    override fun animate() {}
    override fun stopAnimating() {}
//    override fun animateTwice() {}
}

internal open class TalkativeButton : Focusable {
    fun yell() = println("Hey!")
    fun whisper() = println("Let's talk")
}

internal fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}