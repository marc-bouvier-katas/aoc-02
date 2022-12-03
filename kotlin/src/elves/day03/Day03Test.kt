package elves.day03

import elves.day02.Move.*
import elves.day02.Outcome.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class Day03Test : StringSpec() {

    init {

        // Acceptance

        "Part 1 sample" {
            val testInput = readInput("input-sample")
            part1(testInput) shouldBe 41
        }


        "Part 1 result" {
            val testInput = readInput("input")
            part1(testInput) shouldBe 42
        }

        // Inner TDD loop

        // Part 2
        // Acceptance

        "Part 2 sample" {

            val testInput = readInput("input-sample")
            part2(testInput) shouldBe 42
        }

        "Part 2 result" {
            val testInput = readInput("input")
            part2(testInput) shouldBe 42
        }

        // Inner TDD loop

    }
}