package elves.day02

import elves.day02.Move.*
import elves.day02.Outcome.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class Day02Test : StringSpec() {

    init {

        // Acceptance

        "Part 1 sample" {

            /*
                                  Opponent                   You
                            move   outcome score  |     move   outcome score
            A Y    ->        1       0       1           2       6       8
            B X              2       6       8           1       0       1
            C Z              3       3       6           3       3       6
            Total                           15                          15

            */

            val testInput = readInput("input-sample")
            part1(testInput) shouldBe 15
        }


        "Part 1 result" {
            val testInput = readInput("input")
            part1(testInput) shouldBe 13221
        }

        // Inner TDD loop

        "Move against move possible outcomes" {
            forAll(
                row(ROCK, SCISSORS, WIN),
                row(ROCK, ROCK, DRAW),
                row(ROCK, PAPER, LOSE),
                row(SCISSORS, SCISSORS, DRAW),
                row(SCISSORS, ROCK, LOSE),
                row(SCISSORS, PAPER, WIN),
                row(PAPER, SCISSORS, LOSE),
                row(PAPER, ROCK, WIN),
                row(PAPER, PAPER, DRAW),
            ) { yourMove, opponentsMove, outcome ->
                yourMove against opponentsMove shouldBe outcome
            }
        }



        "Moves score" {
            forAll(
                row(ROCK, 1),
                row(PAPER, 2),
                row(SCISSORS, 3),
            ) { move, score ->
                move.score shouldBe score
            }

        }


"Elve coded move decoded" {
    forAll(
        row("A", ROCK),
        row("X", ROCK),
        row("B", PAPER),
        row("Y", PAPER),
        row("C", SCISSORS),
        row("Z", SCISSORS),
    ) { elveEncoded, move ->
        Move of elveEncoded shouldBe move
    }
}

        "Outcome score" {
            forAll(
                row(LOSE, 0),
                row(DRAW, 3),
                row(WIN, 6),
            ) { outcome, score ->
                outcome.score shouldBe score
            }
        }

        "Round possible scores" {
            forAll(
                row("A", "X", 4),
                row("A", "Y", 8),
                row("A", "Z", 3),
                row("B", "X", 1),
                row("B", "Y", 5),
                row("B", "Z", 9),
                row("C", "X", 7),
                row("C", "Y", 2),
                row("C", "Z", 6),
            ) { elveEncodedOpponentMove, elveEncodedYourMove, yourScore ->

                val roundResult = RoundResult(
                    Move.of(elveEncodedOpponentMove),
                    Move.of(elveEncodedYourMove)
                )
                roundResult.yourScore shouldBe yourScore
            }
        }

        // Part 2
        // Acceptance

        "Part 2 sample" {

            // A X : you need to lose against rock
            // B Y : you need to draw against paper
            // C Z : you need to win  against scissors
            val testInput = readInput("input-sample")
            part2(testInput) shouldBe 12
        }

        "Part 2 result" {
            val testInput = readInput("input")
            part2(testInput) shouldBe 13131
        }

        // Inner TDD loop
        "Decode elve encoded outcome hint" {
            forAll(
                row("X", LOSE),
                row("Y", DRAW),
                row("Z", WIN),
            ) { elveEncoded, outcome ->
                Outcome of elveEncoded shouldBe outcome
            }

        }

        "Deduce move to fulfill outcome" {
            forAll(
                row(ROCK, WIN, PAPER),
                row(ROCK, DRAW, ROCK),
                row(ROCK, LOSE, SCISSORS),
                row(PAPER, WIN, SCISSORS),
                row(PAPER, DRAW, PAPER),
                row(PAPER, LOSE, ROCK),
                row(SCISSORS, WIN, ROCK),
                row(SCISSORS, DRAW, SCISSORS),
                row(SCISSORS, LOSE, PAPER),
            ) { opponentMove, outcome, yourMove ->
                opponentMove toFulfill outcome shouldBe yourMove
            }
        }
    }
}