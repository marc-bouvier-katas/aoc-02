package elves

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest


fun part1(encryptedStrategyGuide: List<String>): Int =
    encryptedStrategyGuide
        .map { it.split(" ") }
        .map { RoundResult(Move.of(it[0]), Move.of(it[1])) }
        .let { RoundResults(it) }
        .yourTotalScore

fun part2(encryptedStrategyGuide: List<String>): Int =
    encryptedStrategyGuide
        .map { it.split(" ") }
        .map {
            RoundResult(
                Move.of(it[0]),
                Move.of(it[0]).moveToFulfill(Outcome.of(it[1]))
            )
        }
        .let { RoundResults(it) }
        .yourTotalScore


/**
 * Reads lines from the given input txt file.
 */

fun readInput(name: String): List<String> =
    try {
        File("src/elves", "$name.txt").readLines()
    } catch (e: java.io.FileNotFoundException) {
        // When run in cyber-dojo.org
        File("/sandbox/elves", "$name.txt").readLines()
    }

/**
 * Converts string to md5 hash.
 */
@Suppress("unused")
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
