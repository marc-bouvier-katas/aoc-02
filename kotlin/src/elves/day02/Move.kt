package elves.day02

import elves.day02.Outcome.*


enum class Move(val score: Int) {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    infix fun against(opponentsMove: Move): Outcome = when {

        this == PAPER -> when (opponentsMove) {
            PAPER -> DRAW
            SCISSORS -> LOSE
            else -> WIN
        }

        this == ROCK -> when (opponentsMove) {
            ROCK -> DRAW
            PAPER -> LOSE
            else -> WIN
        }

        this == SCISSORS -> when (opponentsMove) {
            PAPER -> WIN
            SCISSORS -> DRAW
            else -> LOSE
        }

        else -> throw IllegalArgumentException("Unsupported opponent's move $opponentsMove")
    }


   infix fun toFulfill(outcome: Outcome): Move = when (outcome) {
        DRAW -> when (this) {
            ROCK -> ROCK
            PAPER -> PAPER
            SCISSORS -> SCISSORS
        }

        WIN -> when (this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }

        LOSE -> when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }

    }

    companion object {
        infix fun of(elveMoveCode: String): Move {
            return when (elveMoveCode) {
                "A" -> ROCK
                "X" -> ROCK
                "B" -> PAPER
                "Y" -> PAPER
                "C" -> SCISSORS
                "Z" -> SCISSORS
                else -> throw IllegalArgumentException("${elveMoveCode} is not a valid Elve Code!")
            }
        }

    }
}

