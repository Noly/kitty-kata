package codewars;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class detectPangram {
    /*
        A pangram is a sentence that contains every single letter of the alphabet at least once.
        For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
        because it uses the letters A-Z at least once (case is irrelevant).
        Given a string, detect whether or not it is a pangram.
        Return True if it is, False if not. Ignore numbers and punctuation.
    */

    @Test
    void a_pangram_sentence() {
        var expected = isPangram("The quick brown fox jumps over the lazy dog.");
        assertThat(expected, is(true));
    }

    @Test
    void ignore_special_characters() {
        var expected = isPangram("!The quick brown fox jumps over the lazy dog");
        assertThat(expected, is(true));
    }

    @Test
    void ignore_numbers() {
        var expected = isPangram("1The quick brown fox jumps over the lazy dog");
        assertThat(expected, is(true));
    }

    @Test
    void a_no_pangram_sentence() {
        var expected = isPangram("You Should No pass!!");
        assertThat(expected, is(false));
    }

    @Test
    void with_a_empty_sentence() {
        var expected = isPangram("");
        assertThat(expected, is(false));
    }

    @Test
    void with_a_null_sentence() {
        var expected = isPangram(null);
        assertThat(expected, is(false));
    }

    @Test
    void with_a_blank_sentence() {
        var expected = isPangram(" ");
        assertThat(expected, is(false));
    }

    private boolean isPangram(String sentence) {
        return sentence != null &&
                sentence.chars()
                        .map(Character::toLowerCase)
                        .filter(Character::isAlphabetic)
                        .distinct()
                        .count() == 26;
    }
}
