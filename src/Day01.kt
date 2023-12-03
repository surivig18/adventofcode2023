fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val output = testInput.map { s: String ->
        val firstDigit = s.first { it.isDigit() }
        val lastDigit = s.last { it.isDigit() }
        val combined = "$firstDigit$lastDigit"
        combined.toInt()
    }
    println(output.sum())
}
