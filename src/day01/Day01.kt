import kotlin.math.abs
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    fun part1(input: List<String>): Int {
//        return Day01Part1().execute(input)
        return Day01Part1V2().execute(input)
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day01","Day01_test")
    part1(testInput).println()


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01","Day01")
    val part1Result = part1(input)
    part1Result.println()
    check(part1Result == 1882714)

//    part2(input).println()
}


open class Day01Part1() {
    open fun execute(input: List<String>): Int {
        var cumulativeDistance = 0
        measureTimeMillis {
            val pairs= input.map { stringPair ->
                val (right, left) = stringPair.split("   ").map { it.toInt() }
                right to left
            }
            val (left, right) = pairs.toList().unzip()

            val leftSorted = left.sorted()
            val rightSorted = right.sorted()

            leftSorted.onEachIndexed { index, leftItem ->
                val rightItem = rightSorted[index]
                cumulativeDistance += abs(f - s)
            }
        }.also { it.milliseconds.println() }


        return cumulativeDistance
    }
}

class Day01Part1V2(): Day01Part1() {
    override fun execute(input: List<String>): Int {
        var totalDistance = 0

        measureTimeMillis {

                    val inputt = input.map { line ->
                        val (left, right) = line.split("   ").map { it.toInt() }
                        left to right
                    }

                    val leftColumn = inputt.map { it.first }.sorted()
                    val rightColumn = inputt.map { it.second }.sorted()

                    // Calculate the total distance
            totalDistance = leftColumn.zip(rightColumn).sumOf { (left, right) ->
                        kotlin.math.abs(left - right)
                    }
        }.also { it.milliseconds.println() }


        return totalDistance
    }
}
