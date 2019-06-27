package third

val kotlinLogo = """| //
                   .|//
                   .|/ \""".trimMargin(".")

fun main(args: Array<String>) {
    println("12.345-6.A".split("\\.|-".toRegex()))

    println("12.345-6.A".split(".", "-"))

    parsePath("/Users/yole/kotlin-book/chapter.adoc")
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast('.')

    println("Dir: $directory, name: $fileName, ext: $extension")

    println(kotlinLogo)
}

fun parsePath2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    } else println("It isn't a path!")
}