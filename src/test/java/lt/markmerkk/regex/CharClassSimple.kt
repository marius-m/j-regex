package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class CharClassSimple {

    val regexFind = RegexFind()

    @Test
    fun charClass1() {
        // Act
        val matches = regexFind.findMatches("[aeiou]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(6)
        assertThat(matches)
                .extracting("match")
                .contains("a", "u", "o", "i")
    }

    @Test
    fun charClass2() {
        // Act
        val matches = regexFind.findMatches("[bXy]", "Java Tutorials")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charClass3() {
        // Act
        val matches = regexFind.findMatches("f[oa]x", "fax machine")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .contains("fax")
    }

    @Test
    fun charClass4() {
        // Act
        val matches = regexFind.findMatches("f[oa]x", "the quick brown fox")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .contains("fox")
    }

    @Test
    fun charClass5() {
        // Act
        val matches = regexFind.findMatches("sim[ia]l[iae]r", "catch misspellings like simaler")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .contains("simaler")
    }

    @Test
    fun charClass6() {
        // Act
        val matches = regexFind.findMatches("col[ou]r", "coloring book")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .contains("color")
    }

    @Test
    fun charClass7() {
        // Act
        val matches = regexFind.findMatches("col[ou]r", "colouring book")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun charClass8() {
        // Act
        val matches = regexFind.findMatches("[ou]", "colouring book")

        // Assert
        assertThat(matches.size).isEqualTo(5)
    }
}