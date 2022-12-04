fun main() {

    fun String.toSet(): Set<Int> {
        val (begin, end) = this.split("-")
        return (begin.toInt()..end.toInt()).toSet()
    }

    fun part1(input: List<String>): Int {
        return input
            .map { it.split(",") } // into two ranges
            .map { it[0].toSet() to it[1].toSet() }
            .count {
                val (first, second) = it
                first.containsAll(second) || second.containsAll(first)
            }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(",") } // into two ranges
            .map { it[0].toSet() to it[1].toSet() }
            .count {
                val (first, second) = it
                (first intersect second).isNotEmpty()
                // OR
//                first.any { it in second }
            }
    }

    val input = readInputAsList("input-day4")
    println(part1(input))
    println(part2(input))
}
