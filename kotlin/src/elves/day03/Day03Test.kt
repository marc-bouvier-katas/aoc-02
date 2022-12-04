package elves.day03

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe


class Day03Test : StringSpec() {

    init {

        // Acceptance

        "Part 1 sample" {
            val testInput = readInput("input-sample")
            part1(testInput) shouldBe 157
        }


        "Part 1 result" {
            val testInput = readInput("input")
            part1(testInput) shouldBe 7742
        }

        // Inner TDD loop

        "Ascii code of char" {
            'a'.code shouldBe 97
        }

        "Priorité pour un type d'objet" {
            forAll(
                row('a', 1),
                row('b', 2),
                row('j', 10),
                row('z', 26),
                row('A', 27),
                row('B', 28),
                row('C', 29),
                row('Z', 52),
            ) { typeObjet, priority ->

                ItemCategory(typeObjet).priority shouldBe priority
            }

        }

        "Packing error : same category in both compartments" {
            forAll(
                row("aa", 1),
                row("aBcDeafGhI", 1),
            ) { ruckSackContent, priorityOfSharedCategory ->

                RuckSack(ruckSackContent).priorityOfSharedCategory shouldBe priorityOfSharedCategory
            }
        }


        // Part 2
        // Acceptance

        "!Part 2 sample" {
            val testInput = readInput("input-sample")
            part2(testInput) shouldBe 42
        }

        "!Part 2 result" {
            val testInput = readInput("input")
            part2(testInput) shouldBe 42
        }

        // Inner TDD loop

    }
}