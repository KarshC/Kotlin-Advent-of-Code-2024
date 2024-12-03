import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map {list ->
            val first = list.substringBefore(" ").toInt()
            val second = list.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        var distance = 0

        left.sorted().zip(right.sorted()).forEach { (first, second) ->
            distance += abs(second - first)
        }
        return distance
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
