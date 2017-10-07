package lt.markmerkk.regex

import java.util.regex.Pattern


class RegexFind {

    fun findMatches(regex: String, inputText: String): List<RegexMatch> {
        val matches = mutableListOf<RegexMatch>()
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(inputText)
        while (matcher.find()) {
            matches.add(
                    RegexMatch(
                            regex,
                            inputText,
                            matcher.group(),
                            matcher.start()
                    )
            )
        }
        matches.print()
        return matches
    }

    class RegexMatch(
            val regex: String,
            val inputText: String,
            val match: String,
            val index: Int
    )
}

fun List<RegexFind.RegexMatch>.print() {
    if (this.isEmpty()) {
        println("----------------------------------------")
        println("No matches!")
        println("----------------------------------------")
        return
    }
    println("----------------------------------------")
    println("Looking through: '${this[0].inputText}'")
    println("Got ${this.size} matches")
    this.forEach {
        println("Found '${it.match}' at ${it.index}")
    }
    println("----------------------------------------")
}
