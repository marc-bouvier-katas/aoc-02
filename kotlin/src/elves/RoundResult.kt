package elves

class RoundResult(opponentMove: Move, yourMove: Move) {

    val yourScore: Int
    val opponentScore: Int

    init {
        yourScore = yourMove.against(opponentMove).score + yourMove.score
        opponentScore = opponentMove.against(yourMove).score + opponentMove.score
    }
}
