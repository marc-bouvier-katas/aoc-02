package elves.day03

class PackingReport(s: Char?) {
    val categoryInBothCompartments: ItemCategory?
    private var status: PackingStatus

    init {

        if (s != null) {
            categoryInBothCompartments = ItemCategory(s)
            status = PackingStatus.OBJECT_TYPE_IN_BOTH_COMPARTMENTS
        } else {
            categoryInBothCompartments = null
            status = PackingStatus.OKAY

        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PackingReport

        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        return status.hashCode()
    }

    override fun toString(): String {
        return "PackingReport(categoryInBothCompartments=$categoryInBothCompartments, status=$status)"
    }


}


enum class PackingStatus {
    OKAY,
    OBJECT_TYPE_IN_BOTH_COMPARTMENTS
}