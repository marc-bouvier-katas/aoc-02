package elves.day03

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest


fun part1(input: List<String>): Int =
    input.map { RuckSack(it) }
        .mapNotNull { it.priorityOfSharedCategory }
        .sum()


fun part2(input: List<String>): Int = -1


/**
 * Reads lines from the given input txt file.
 */

fun readInput(name: String): List<String> =
    try {
        File("src/elves/day03", "$name.txt").readLines()
    } catch (e: java.io.FileNotFoundException) {
        // When run in cyber-dojo.org
        File("/sandbox/elves/day03", "$name.txt").readLines()
    }

/**
 * Converts string to md5 hash.
 */
@Suppress("unused")
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
