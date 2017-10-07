package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class IpAddress {

    val regexFind = RegexFind()

    @Test
    fun allChars() {
        // Act
        val matches = regexFind.findMatches(".", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(12)
    }

    @Test
    fun escapeDotChars() {
        // Act
        val matches = regexFind.findMatches("\\.", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches).extracting("match")
                .contains(".")
    }

    @Test
    fun escapeDotChars_weirdEscape() {
        // Act
        val matches = regexFind.findMatches("\\Q.\\E", "107.1.53.254")

        // Assert
        assertThat(matches.size).isEqualTo(3)
        assertThat(matches).extracting("match")
                .contains(".")
    }

    @Test
    fun threeMetas() {
        // Act
        val matches = regexFind.findMatches("...", "Blah blah ... blah blah")

        // Assert
        assertThat(matches.size).isEqualTo(7)
        assertThat(matches).extracting("match")
                .contains(
                        "Bla",
                        "h b",
                        "lah",
                        " ..",
                        ". b",
                        "lah",
                        " bl"
                )
    }

    @Test
    fun threeDots() {
        // Act
        val matches = regexFind.findMatches("\\.\\.\\.", "Blah blah ... blah blah")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .containsOnly("...")
    }

    @Test
    fun threeDots_stacked() {
        // Act
        val matches = regexFind.findMatches("\\Q...\\E", "Blah blah ... blah blah")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .containsOnly("...")
    }

    @Test
    fun integerFind() {
        // Act
        val matches = regexFind.findMatches("[41]", "new int[41]")

        // Assert
        assertThat(matches.size).isEqualTo(2)
        assertThat(matches).extracting("match")
                .containsOnly("4", "1")
    }

    @Test
    fun integerFind_escaped() {
        // Act
        val matches = regexFind.findMatches("\\Q[41]\\E", "new int[41]")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .containsOnly("[41]")
    }

    @Test
    fun integerFind_escaped2() {
        // Act
        val matches = regexFind.findMatches("\\Q[41]\\E", "new int[14]")

        // Assert
        assertThat(matches.size).isEqualTo(0)
    }

    @Test
    fun integerFind_escaped_onlySomeChars() {
        // Act
        val matches = regexFind.findMatches("\\[41\\]", "new int[41]")

        // Assert
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches).extracting("match")
                .containsOnly("[41]")
    }

}