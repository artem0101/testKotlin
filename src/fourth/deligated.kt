package fourth

data class Client(val name: String, val postalCode: Int) {
    override fun toString(): String = "Client(name = $name, postalCode = $postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {
//    private val innerList = arrayListOf<T>()
//
//    override val size: Int
//        get() = innerList.size
//
//    override fun isEmpty(): Boolean = innerList.isEmpty()
//
//    override fun contains(element: T): Boolean = innerList.contains(element)
//
//    override fun iterator(): Iterator<T> = innerList.iterator()
//
//    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
}

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = HashSet()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded =+ elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val client1 = Client("Alice", 94842)
    val client2 = client1.copy()
    println(client1)
    println(client1 == client2)

    println()

    val processed = hashSetOf(Client("Eva", 948220))
    println(processed.contains(Client("Eva", 948220)))

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 2, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}