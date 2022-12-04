fun main() {

    fun String.intoHalves(): List<String> {
        return listOf(substring(0..length/2), substring(length/2))
    }

    fun List<String>.findCommonCharacter(): Char {
        return this.map { it.toSet() }
            .reduce { left, right -> left intersect right  }
            .first()
    }

    fun Char.toPriority(): Int =
        if(isUpperCase()) {
            this - 'A' + 27
        } else {
            this - 'a' + 1
        }


    fun part1(input: List<String>): Int {
        return input
            .map { it.intoHalves() }
            .map { it.findCommonCharacter() }
            .sumOf { it.toPriority() }
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .map { it.findCommonCharacter() }
            .sumOf { it.toPriority() }
    }

    val input = readInputAsList("input-day3")
    println(part1(input))
    println(part2(input))
}
