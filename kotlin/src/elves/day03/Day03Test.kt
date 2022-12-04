package elves.day03

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

const val ASCIICODE_FOR_A_LOWERCASE = 97
const val ASCIICODE_FOR_A_UPPERCASE = 65

class Day03Test : StringSpec() {

    init {

        // Acceptance

        "!Part 1 sample" {
            val testInput = readInput("input-sample")
            part1(testInput) shouldBe 157
        }


        "!Part 1 result" {
            val testInput = readInput("input")
            part1(testInput) shouldBe 42
        }

        // Inner TDD loop

        "Ascii code of char" {
            'a'.code shouldBe 97
        }

        "Priorité pour un type d'objet" {
            forAll(
                row("a", 1),
                row("b", 2),
                row("j", 10),
                row("z", 26),
                row("A", 27),
                row("B", 28),
                row("C", 29),
                row("Z", 52),
            ) { typeObjet, priorite ->

                priorityOf(typeObjet) shouldBe priorite
            }

        }

        "Size of compartments from rucksack" {
            forAll(
                row("ab", 1),
                row("aAbB", 2),
                row("vJrwpWtwJgWrhcsFMMfFFhFp", 12),
            ) { ruckSackContent, compartmentsSize ->

                val ruckSack = RuckSack((ruckSackContent))
                ruckSack.firstCompartment.size shouldBe compartmentsSize
                ruckSack.secondCompartment.size shouldBe compartmentsSize
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

    // ca va être un peu long à écrire mais
    // c'est une solution posible, car on sait que on aura que a-z et A-Z
    // on peut soit l'écrire à la main, soit générer cette table d correspondance avec du code
    // si on décide de choisir cette approche

    fun priorityOf(typeObjet: String): Int {


        val asciiCode = typeObjet.chars().findFirst().asInt

        return if (asciiCode in (97..122))
            asciiCode - ASCIICODE_FOR_A_LOWERCASE + 1 // ici le 1 c'est la priorité de départ depuis "a"
        else {
            asciiCode - ASCIICODE_FOR_A_UPPERCASE + 27 // 27 c'est la priorité de départ depuis "A"
        }
// c'est bien ici, on peut s'errêter là.


    }
}