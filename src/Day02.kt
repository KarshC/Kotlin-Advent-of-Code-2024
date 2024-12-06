import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var safeLines = 0
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            if (isLineSafe(numbers)) safeLines++
        }
        return safeLines
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }
            var isSafe = false
            for (i in 0..numbers.lastIndex) {
                isSafe = isLineSafe(numbers.toMutableList().apply { removeAt(i) })
                if (isSafe) {
                    result++
                    break
                }
            }
        }
        return result
    }

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}