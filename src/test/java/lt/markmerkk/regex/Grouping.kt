package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class Grouping {

    val regexFind = RegexFind()

    @Test
    fun grouping1() {
        // Act
        val matches = regexFind.findMatches("(broom)", inputText)

        // Assert
        assertThat(matches)
                .extracting("match")
                .contains("top", "mop")
    }
}