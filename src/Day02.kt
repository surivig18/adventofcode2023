fun main() {
    // test if implementation meets criteria from the description, like:
    val numberStrings = mapOf(
        "one" to '1', "two" to '2', "three" to '3',
        "four" to '4', "five" to '5', "six" to '6', "seven" to '7', "eight" to '8', "nine" to '9',
    )
    val testInput = readInput("Day02_test")
    val output = testInput.map { s: String ->
        val match = s.find { it.isDigit() }
        val matchFirst = s.indexOfFirst { it == match }

        val matchList = numberStrings.keys.mapNotNull { str->
            if (s.contains(str)) {
                s.indexOfFirst { it == str.first() } to str
            }
            else null
        }.toMap()

       val something = matchList[matchList.toSortedMap().keys.firstOrNull()]
        val matchSecond = s.indexOfFirst { it == something?.first() }
        println(match)
        println(matchFirst)
        println(matchSecond)
        val firstDigit: Char = if ((matchFirst != -1 && matchFirst < matchSecond) || matchSecond == -1) {
            match!!
        } else {
            val match2 = numberStrings[something]
            println(match2)
            match2!!
        }
        println(firstDigit)
        val matchLast = s.findLast { it.isDigit() }
        val matchLastFirst = s.indexOfLast { it == match }
        val matchList2 = numberStrings.keys.mapNotNull { str->
            if (s.contains(str)) {
                s.indexOfFirst { it == str.first() } to str
            }
            else null
        }.toMap()

        val something2 = matchList2[matchList2.toSortedMap().keys.firstOrNull()]
        val matchLastSecond = s.indexOfLast { it == something2?.first() }

        val lastDigit: Char = if ((matchLastFirst != -1 && matchLastFirst > matchLastSecond )|| matchLastSecond == -1) {
            matchLast!!
        } else {
            numberStrings[something2]!!
        }
        val combined = "$firstDigit$lastDigit"
        combined.toInt()
    }
    println(output.sum())
}
