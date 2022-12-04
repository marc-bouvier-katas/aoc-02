package elves.day03

class RuckSack(s: String) {


    val secondCompartment: Compartment
    val firstCompartment: Compartment

    init {
        firstCompartment = Compartment(s.take(s.length/2))
        secondCompartment = Compartment(s.takeLast(s.length/2))
    }
}
