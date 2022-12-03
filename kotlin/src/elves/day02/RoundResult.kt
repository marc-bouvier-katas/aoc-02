package elves.day02

class RoundResult(opponentMove: Move, yourMove: Move) {

    val yourScore: Int

    init {
        yourScore = yourMove.against(opponentMove).score + yourMove.score
    }
}
