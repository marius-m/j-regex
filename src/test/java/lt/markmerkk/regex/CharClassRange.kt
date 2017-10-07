package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class CharClassRange {

    val regexFind = RegexFind()

    @Test
    fun range1() {
        // Act
        val matches = regexFind.findMatches("[a-d]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches)
                .extracting("match")
                .contains("a")
    }

    @Test
    fun range2() {
        // Act
        val matches = regexFind.findMatches("[A-M]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches)
                .extracting("match")
                .contains("J")
    }

    @Test
    fun range3() {
        // Act
        val matches = regexFind.findMatches("[1-5]", "5 limes for $1")

        // Assert
        assertThat(matches.size).isEqualTo(2)
        assertThat(matches)
                .extracting("match")
                .contains("1", "5")
    }

    @Test
    fun range4() {
        // Act
        val matches = regexFind.findMatches("[^a-d]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(11)
        assertThat(matches)
                .extracting("match")
                .contains("J", "v", " ", "T", "u", "t", "o", "r", "i", "l", "s")
    }

    @Test
    fun range5() {
        // Act
        val matches = regexFind.findMatches("[^1-5]", "5 limes for $1")

        // Assert
        assertThat(matches.size).isEqualTo(12)
        assertThat(matches)
                .extracting("match")
                .contains(" ", "l", "m", "e", "s", "f", "o", "r", "$")
    }

    @Test
    fun range6() {
        // Act
        val matches = regexFind.findMatches("col[o-u]r", "coloring book")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches)
                .extracting("match")
                .contains("color")
    }

    @Test
    fun range7() {
        // Act
        val matches = regexFind.findMatches("col[o-u]r", "colouring book")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

}