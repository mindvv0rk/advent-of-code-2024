import kotlin.math.abs
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    fun splitLists(input: List<String>): List<Pair<Int, Int>>{
        return input.map { stringPair ->
            val (right, left) = stringPair.split("   ").map { it.toInt() }
            right to left
        }
    }

    fun part1(input: List<String>): Int {
        var cumulativeDistance = 0
        measureTimeMillis {
            val (left, right) = splitLists(input).unzip()

            val leftSorted = left.sorted()
            val rightSorted = right.sorted()

            leftSorted.onEachIndexed { index, leftItem ->
                val rightItem = rightSorted[index]
                cumulativeDistance += abs(leftItem - rightItem)
            }
        }.also { it.milliseconds.println() }

        return cumulativeDistance
    }

    fun part2(input: List<String>): Int {
        val (left, right) = splitLists(input).unzip()

        return left.sumOf { leftItem ->
            val count = right.count { leftItem == it }
            leftItem * count
        }
    }



    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day01","Day01_test")
    part1(testInput).println()
    part2(testInput).println()


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01","Day01")
    val part1Result = part1(input)
    part1Result.println()
    check(part1Result == 1882714)
    part2(input).println()
}