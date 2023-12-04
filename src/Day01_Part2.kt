fun main() {
    // test if implementation meets criteria from the description, like:
    val numberStrings = mapOf(
        "one" to '1', "two" to '2', "three" to '3',
        "four" to '4', "five" to '5', "six" to '6', "seven" to '7', "eight" to '8', "nine" to '9',
    )
    val testInput = readInput("Day01_Part2")
//    val testInput = listOf("seven8sevenptdlvvgssixvjvzpvsp7fivefourtwoned")
    val output = testInput.map { s: String ->
        val match = s.find { it.isDigit() }
        val matchFirst = s.indexOfFirst { it == match }

        val matchList = numberStrings.keys.mapNotNull { str ->
            if (s.contains(str)) {
                s.indexOf(str) to str
            } else {
                null
            }
        }.toMap().toSortedMap()

        val matchSecond = matchList.keys.firstOrNull() ?: -1
        val firstDigit: Char = if ((matchFirst != -1 && matchFirst < matchSecond) || matchSecond == -1) {
            match!!
        } else {
            val match2 = numberStrings[matchList[matchSecond]]
            match2!!
        }
        val matchLast = s.findLast { it.isDigit() }
        val matchLastFirst = s.indexOfLast { it == matchLast }
        val matchList2 = numberStrings.keys.mapNotNull { str ->
            if (s.contains(str)) {
                s.lastIndexOf(str) to str
            } else {
                null
            }
        }.toMap().toSortedMap()
        val matchLastSecond = matchList2.keys.lastOrNull() ?: -1
        val lastDigit: Char = if ((matchLastFirst != -1 && matchLastFirst > matchLastSecond) || matchLastSecond == -1) {
            matchLast!!
        } else {
            numberStrings[matchList2[matchLastSecond]]!!
        }

        val combined = "$firstDigit$lastDigit"
        println(combined)
        combined.toInt()
    }
    println(output.sum())
}
