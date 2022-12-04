package elves.day03

class RuckSack(elveEncodedContent: String) {

    val priorityOfSharedCategory: Int?

    init {
        val firstCompartment = Compartment(elveEncodedContent.take(elveEncodedContent.length / 2))
        val secondCompartment = Compartment(elveEncodedContent.takeLast(elveEncodedContent.length / 2))

        priorityOfSharedCategory =
            firstCompartment.intersectionWith(secondCompartment).categoryInBothCompartments?.priority
    }


}


private class Compartment(s: String) {
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


const val ASCIICODE_FOR_A_LOWERCASE = 97
const val ASCIICODE_FOR_A_UPPERCASE = 65

class ItemCategory(categoryCode: Char) {
    val priority: Int

    init {
        priority = priorityOf(categoryCode)
    }

    private fun priorityOf(typeObjet: Char): Int {


        val asciiCode = typeObjet.code

        return if (asciiCode in (97..122))
            asciiCode - ASCIICODE_FOR_A_LOWERCASE + 1 // ici le 1 c'est la priorité de départ depuis "a"
        else {
            asciiCode - ASCIICODE_FOR_A_UPPERCASE + 27 // 27 c'est la priorité de départ depuis "A"
        }
// c'est bien ici, on peut s'errêter là.


    }
}

private class PackingReport(s: Char?) {
    val categoryInBothCompartments: ItemCategory?

    init {

        if (s != null) {
            categoryInBothCompartments = ItemCategory(s)
        } else {
            categoryInBothCompartments = null

        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PackingReport

        if (categoryInBothCompartments != other.categoryInBothCompartments) return false

        return true
    }

    override fun hashCode(): Int {
        return categoryInBothCompartments?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "PackingReport(categoryInBothCompartments=$categoryInBothCompartments)"
    }


}

