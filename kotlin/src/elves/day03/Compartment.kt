package elves.day03

class Compartment(s: String) {
    fun intersectionWith(secondCompartment: Compartment): PackingReport {
        val other: CharArray = secondCompartment.content.toCharArray()
        val intersect: Set<Char> = content.toCharArray().intersect(other.asIterable().toSet())
        return PackingReport(intersect.firstOrNull())
    }

    private var content: String

    init {
        content = s
    }
}
