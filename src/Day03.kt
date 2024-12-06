fun main() {
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            // Find all matches and process them
            result += regex.findAll(line)
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

    fun part2(input: List<String>): Int {

    }

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}