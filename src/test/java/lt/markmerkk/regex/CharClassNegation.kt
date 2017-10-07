package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class CharClassNegation {

    val regexFind = RegexFind()

    @Test
    fun charNegation1() {
        // Act
        val matches = regexFind.findMatches("[^aeiou]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(8)
        assertThat(matches)
                .extracting("match")
                .contains("J", "v", " ", "T", "t", "r", "l", "s")
    }

    @Test
    fun charNegation2() {
        // Act
        val matches = regexFind.findMatches("[^bXy]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(14)
    }

    @Test
    fun charNegation3() {
        // Act
        val matches = regexFind.findMatches("f[^oa]x", "fax machine")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charNegation4() {
        // Act
        val matches = regexFind.findMatches("f[^oa]x", "the quick brown fox")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charNegation5() {
        // Act
        val matches = regexFind.findMatches("sim[^ia]l[^iae]r", "catch misspellings like simaler")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charNegation6() {
        // Act
        val matches = regexFind.findMatches("col[^ou]r", "coloring book")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charNegation7() {
        // Act
        val matches = regexFind.findMatches("col[^ou]r", "colouring book")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charNegation8() {
        // Act
        val matches = regexFind.findMatches("[^ou]", "colouring book")

        // Assert
        assertThat(matches.size).isEqualTo(9)
        assertThat(matches).extracting("match")
                .contains("c", "l", "r", "i", "n", "g", " ", "b", "k")
    }

}