import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.math.abs

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun createIntPairFromStringList (input: List<String>): Pair<List<Int>, List<Int>> {
    return input.map {list ->
        val first = list.substringBefore(" ").toInt()
        val second = list.substringAfterLast(" ").toInt()
        first to second
    }.unzip()
}

fun isLineSafe(numbers: List<Int>): Boolean {
    var safe = true
    var isUp = true
    var isDown = true
    for (i in 0 until numbers.lastIndex) {
        val a = numbers[i]
        val b = numbers[i+1]
        safe = safe && (abs(a - b) <= 3)

        when {
            a < b -> isDown = false
            b < a -> isUp = false
            else -> {
                isUp = false
                isDown = false
            }
        }
    }
    return safe && (isUp || isDown)
}
