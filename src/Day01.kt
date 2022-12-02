fun main() {
    fun caloriesSummed(input: String): List<Int> =
        input
            .trim()
            .split("\n\n")
            .map { it -> it.lines().sumOf { it.toInt() } }
            .sortedDescending()

    fun part1(input: String): Int {
        return caloriesSummed(input).first()
    }

    fun part2(input: String): Int {
        return caloriesSummed(input).take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInputAsString("input-day1")
//    check(part1(testInput) == 1)

    val input = readInputAsString("input-day1")
    println(part1(input))
    println(part2(input))
}
