package elves

enum class Outcome(val score: Int, val elveEncoded: String) {

    WIN(6, "Z"),
    DRAW(3, "Y"),
    LOSE(0, "X");

    companion object {
        fun of(elveEncoded: String): Outcome {
            return values().find { it.elveEncoded == elveEncoded }
                ?: throw IllegalArgumentException("Unexpected elve encoded outcome $elveEncoded")

        }
    }

}
