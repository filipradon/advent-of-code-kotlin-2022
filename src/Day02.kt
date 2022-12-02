import Result.Companion.toRightResult
import Shape.Companion.toLeftShape
import Shape.Companion.toRightShape

sealed interface Shape {
    companion object {
        fun Char.toLeftShape(): Shape {
            return when (this) {
                'A' -> Rock
                'B' -> Paper
                'C' -> Scissors
                else -> throw IllegalArgumentException()
            }
        }

        fun Char.toRightShape(): Shape {
            return when (this) {
                'X' -> Rock
                'Y' -> Paper
                'Z' -> Scissors
                else -> throw IllegalArgumentException()
            }
        }
    }
}

object Rock : Shape
object Paper : Shape
object Scissors : Shape

sealed interface Result {
    companion object {
        fun Char.toRightResult(): Result {
            return when (this) {
                'X' -> Lose
                'Y' -> Draw
                'Z' -> Win
                else -> throw IllegalArgumentException()
            }
        }
    }
}

object Lose : Result
object Draw : Result
object Win : Result

fun result(left: Shape, right: Shape): Int {
    return when (right) {
        is Rock -> when (left) {
            is Paper -> 1 + 0
            is Rock -> 1 + 3
            is Scissors -> 1 + 6
        }

        is Paper -> when (left) {
            is Paper -> 2 + 3
            is Rock -> 2 + 6
            is Scissors -> 2 + 0
        }

        is Scissors -> when (left) {
            is Paper -> 3 + 6
            is Rock -> 3 + 0
            is Scissors -> 3 + 3
        }
    }
}

fun result(left: Shape, right: Result): Int {
    return when (right) {
        Lose -> when (left) {
            Paper -> 1 + 0
            Rock -> 3 + 0
            Scissors -> 2 + 0
        }

        Draw -> when (left) {
            Paper -> 2 + 3
            Rock -> 1 + 3
            Scissors -> 3 + 3
        }

        Win -> when (left) {
            Paper -> 3 + 6
            Rock -> 2 + 6
            Scissors -> 1 + 6
        }
    }
}

fun calculateRockPaperScissorsResult(input: List<String>): Int {
    return input
        .map { it.trim() }
        .sumOf { result(it[0].toLeftShape(), it[2].toRightShape()) }
}

fun calculateRockPaperScissorsResult2(input: List<String>): Int {
    return input
        .map { it.trim() }
        .sumOf { result(it[0].toLeftShape(), it[2].toRightResult()) }
}



fun main() {
    fun part1(input: List<String>): Int {
        return calculateRockPaperScissorsResult(input)
    }

    fun part2(input: List<String>): Int {
        return calculateRockPaperScissorsResult2(input)
    }

    val input = readInputAsList("input-day2")
    println(part1(input))
    println(part2(input))

    // test if implementation meets criteria from the description, like:
//    val testInput = readInputAsString("input-day1")
//    check(part1(testInput) == 1)


}