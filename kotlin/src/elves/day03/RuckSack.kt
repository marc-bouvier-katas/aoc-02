package elves.day03

class RuckSack(s: String) {

    val packingReport: PackingReport

    init {
        val firstCompartment = Compartment(s.take(s.length / 2))
        val secondCompartment = Compartment(s.takeLast(s.length / 2))
        packingReport = firstCompartment.intersectionWith(secondCompartment)
    }
}
