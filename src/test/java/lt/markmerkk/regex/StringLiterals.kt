package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class StringLiterals {

    val regexFind = RegexFind()

    @Test
    fun simple() {
        // Act
        val matches = regexFind.findMatches("lime", "5 limes for $1")

        // Assert
        assertThat(matches)
                .extracting("match")
                .contains("lime")
    }

    @Test
    fun simple_withUpperCase() {
        // Act
        val matches = regexFind.findMatches("java", "Java Tutorials") // cant fund because of uppercase J

        // Assert
        assertThat(matches).isEmpty()
    }

    @Test
    fun simple_twoFinds() {
        // Act
        val matches = regexFind.findMatches("round", "The wheels on the bus go round and round")

        // Assert
        assertThat(matches).extracting("match")
                .contains("round", "round")
    }

    @Test
    fun simple_spaces() {
        // Act
        val matches = regexFind.findMatches(" ", "The wheels on the bus go round and round")

        // Assert
        assertThat(matches.size).isEqualTo(8)
    }

    @Test
    fun metaChar1() {
        // Act
        val matches = regexFind.findMatches(".", "107.1.53.254") // metacharacter that indicates any char

        // Assert
        assertThat(matches.size).isEqualTo(12)
    }

    @Test
    fun metaChar2() {
        // Act
        val matches = regexFind.findMatches("$", "5 limes for $1" ) // metacharacter that indicates end of string

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .contains("")
    }

}