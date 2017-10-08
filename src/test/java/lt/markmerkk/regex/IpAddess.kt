package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class IpAddess {

    val regexFind = RegexFind()

    @Test
    fun allNumbers() {
        // Act
        val matches = regexFind.findMatches("[0-9]", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(9)
        assertThat(matches).extracting("match")
                .contains("1", "0", "7", "5", "3", "2", "4")
    }

    @Test
    fun allNumbers_shortCut() {
        // Act
        val matches = regexFind.findMatches("\\d", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(9)
        assertThat(matches).extracting("match")
                .contains("1", "0", "7", "5", "3", "2", "4")
    }

    @Test
    fun notNumbers() {
        // Act
        val matches = regexFind.findMatches("[^0-9]", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches).extracting("match")
                .contains(".")
    }

    @Test
    fun notNumbers_shortCut() {
        // Act
        val matches = regexFind.findMatches("\\D", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches).extracting("match")
                .contains(".")
    }

    @Test
    fun separators() {
        // Act
        val matches = regexFind.findMatches("[ \\n\\r\\t\\f]", "Hello world\n")

        // Assert
        assertThat(matches.size).isEqualTo(2)
        assertThat(matches).extracting("match")
                .contains(" ", "\n")
    }

    @Test
    fun separators_shortCut() {
        // Act
        val matches = regexFind.findMatches("\\s", "Hello world\n")

        // Assert
        assertThat(matches.size).isEqualTo(2)
        assertThat(matches).extracting("match")
                .contains(" ", "\n")
    }

    @Test
    fun separators_negate() {
        // Act
        val matches = regexFind.findMatches("[\\S]", "Hello world\n")

        // Assert
        assertThat(matches.size).isEqualTo(10)
        assertThat(matches).extracting("match")
                .doesNotContain(" ", "\n")
    }


}