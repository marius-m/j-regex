package lt.markmerkk.regex

import org.junit.Test
import org.assertj.core.api.Assertions.*

class Basic1 {

    val regexFind = RegexFind()

    @Test
    fun simple1() {
        // Assemble
        val inputText = "The top of the mop is called a handle."

        // Act
        val matches = regexFind.findMatches("[tm]op", inputText)

        // Assert
        assertThat(matches)
                .extracting("match")
                .contains("top", "mop")
    }
}