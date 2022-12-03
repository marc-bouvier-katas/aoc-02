package elves.day02

class RoundResults(results: List<RoundResult>) {

    val yourTotalScore: Int = results.sumOf { it.yourScore }
}
