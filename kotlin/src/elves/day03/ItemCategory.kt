package elves.day03

class ItemCategory(categoryCode: Char) {
val priority:Int

init {
    priority = priorityOf(categoryCode)
}

    private fun priorityOf(typeObjet: Char): Int {


        val asciiCode = typeObjet.code

        return if (asciiCode in (97..122))
            asciiCode - ASCIICODE_FOR_A_LOWERCASE + 1 // ici le 1 c'est la priorité de départ depuis "a"
        else {
            asciiCode - ASCIICODE_FOR_A_UPPERCASE + 27 // 27 c'est la priorité de départ depuis "A"
        }
// c'est bien ici, on peut s'errêter là.


    }
}
