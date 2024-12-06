fun main() {
    val mulRegex = """mul\((\d{1,3}),(\d{1,3})\)"""

    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            // Find all matches and process them
            result += mulRegex.toRegex().findAll(line)
                .map { matchResult ->
                    // Extract X and Y from the match groups
                    val x = matchResult.groupValues[1].toInt()
                    val y = matchResult.groupValues[2].toInt()
                    x * y // Multiply X and Y
                }
                .sum() // Sum all the products
        }
        return result
    }

    fun MatchResult.multiplyNumbers(): Int {
        val (first, second) = destructured
        return first.toInt() * second.toInt()
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        var sumEnable = true
        val doRegex = """do\(\)"""
        val dontRegex = """don't\(\)"""

        for (line in input) {
            """$mulRegex|$doRegex|$dontRegex""".toRegex().findAll(line).forEach { match ->
                when (match.value) {
                    "don't()" -> sumEnable = false
                    "do()" -> sumEnable = true
                    else -> if(sumEnable) sum += match.multiplyNumbers()
                }
            }
        }
        return sum
    }

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}