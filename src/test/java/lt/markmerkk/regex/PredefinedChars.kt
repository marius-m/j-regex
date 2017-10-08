package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class PredefinedChars {

    val regexFind = RegexFind()

    // Same as "[0-9]"
    // digits 0 through 9
    @Test
    fun digits() {
        // Act
        val matches = regexFind.findMatches("\\d", "We payed $5 for the lady")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches)
                .extracting("match")
                .containsOnly("5")
    }

    // Same as "[^0-9]"
    // any character except the digits 0 through 9
    @Test
    fun digits_negate() {
        // Act
        val matches = regexFind.findMatches("\\D", "$5 Dollars")

        // Assert
        assertThat(matches.size).isEqualTo(9)
        assertThat(matches)
                .extracting("match")
                .containsOnly("$", " ", "D", "o", "l", "a", "r", "s")
    }

    // Same as "[ \\n\\r\\t\\f]"
    // regular space, newline, carriage return, tab, and formfeed
    @Test
    fun separators() {
        // Act
        val matches = regexFind.findMatches("\\s", "ive got $5 dollars")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches)
                .extracting("match")
                .containsOnly(" ")
    }

    // Same as "[^\\s]"
    // any character except for a space, newline, carriage return, tab, or formfe
    @Test
    fun separators_negate() {
        // Act
        val matches = regexFind.findMatches("\\S", "ive got $5 dollars")

        // Assert
        assertThat(matches.size).isEqualTo(15)
        assertThat(matches)
                .extracting("match")
                .doesNotContain(" ")
    }

    // Same as "[a-zA-Z0-9_]"
    // lowercase a-z, uppercase A-Z, digits 0 through 9, and the underscore
    @Test
    fun lettersAndNumbers() {
        // Act
        val matches = regexFind.findMatches("\\w", "ive got $5 dollars")

        // Assert
        assertThat(matches.size).isEqualTo(14)
        assertThat(matches)
                .extracting("match")
                .doesNotContain(" ", "$")
    }

    // Same as "[^\\w]"
    // anything except lowercase a-z, uppercase A-Z, digits 0 through 9, or underscore
    @Test
    fun lettersAndNumbers_negate() {
        // Act
        val matches = regexFind.findMatches("\\W", "ive got $5 dollars")

        // Assert
        assertThat(matches.size).isEqualTo(4)
        assertThat(matches)
                .extracting("match")
                .contains("$", " ")
    }
}