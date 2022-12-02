package elves

import elves.Move.*
import elves.Outcome.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

// First column: what the opponent is going to play
// A : Rock
// B : Paper
// C : Scissors

// Second column... ?
// Unsuspicious response moves
// X : Rock
// Y : Paper
// Z : Scissors

// Total score : sum of your scores of each rounds

// Winner of the tournament : player with Highest score

// Score for a round :
// shape score + outcome score

// Shape score :
// 1 : Rock
// 2 : Paper
// 3 : Scissors

// Outcome score
// 0 : lost
// 3 : draw
// 6  : won

// Calculate the score you would get if following the strategy guide


// What would your total score be
// if everything goes exactly according to your strategy guide?

class Day02Test : StringSpec() {

    init {

        // Acceptance

        "Part 1 sample" {
            //                  Opponent                   You
            //              shape   outcome score  |    shape   outcome score
            // A Y    ->        1       0       1           2       6       8
            // B X              2       6       8           1       0       1
            // C Z              3       3       6           3       3       6
            // Total                           15                          15

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
                yourMove.against(opponentsMove) shouldBe outcome
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
            ) { elveCode, move ->
                Move.of(elveCode) shouldBe move
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

        "Round scores" {
            forAll(
                row("A", "X", 4, 4),
                row("A", "Y", 8, 1),
                row("A", "Z", 3, 7),
                row("B", "X", 1, 8),
                row("B", "Y", 5, 5),
                row("B", "Z", 9, 2),
                row("C", "X", 7, 3),
                row("C", "Y", 2, 9),
                row("C", "Z", 6, 6),
            ) { opponentsMoveElveEncoded, yourMoveElveEncoded, yourScore, opponentScore ->

                val roundResult = RoundResult(
                    Move.of(opponentsMoveElveEncoded),
                    Move.of(yourMoveElveEncoded)
                )
                roundResult.yourScore shouldBe yourScore
                roundResult.opponentScore shouldBe opponentScore
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

        // Inner loop TDD
        "Decode elve encoded outcome hint" {
            forAll(
                row("X", LOSE),
                row("Y", DRAW),
                row("Z", WIN),
            ) { outcomeHintElveEncoded, outcome ->
                Outcome.of(outcomeHintElveEncoded) shouldBe outcome
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
            ) { opponentMove, outcome, moveToFullfillOutcome ->
                opponentMove.moveToFulfill(outcome) shouldBe moveToFullfillOutcome
            }

        }

    }


}