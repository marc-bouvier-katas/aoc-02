    package hiker

    import java.io.File
    import java.math.BigInteger
    import java.net.URI
    import java.security.MessageDigest


    fun answer(): Int {
        return 6 * 9
    }

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    /**
     * Reads lines from the given input txt file.
     */

    fun readInput(name: String): List<String> {
        try {
            return File("src", "$name.txt").readLines()
        } catch (e: java.io.FileNotFoundException) {
            // When run in cyber-dojo.org
            return File("/sandbox/", "$name.txt").readLines()
        }
    }

    //fun readInput(url: )

    fun readInput(uri: URI): List<String> = File(uri).readLines()

    /**
     * Converts string to md5 hash.
     */
    fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')
