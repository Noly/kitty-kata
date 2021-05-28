package codewars;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class twoToOne {
    /*
        Take 2 strings s1 and s2 including only letters from a to z.
        Return a new sorted string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
        Examples:
            a = "xyaabbbccccdefww"
            b = "xxxxyyyyabklmopq"
            longest(a, b) -> "abcdefklmopqwxy"

            a = "abcdefghijklmnopqrstuvwxyz"
            longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
     */

    @Test
    void take_longest() {
        assertThat(longest("aretheyhere", "yestheyarehere"), is("aehrsty"));
        assertThat(longest("loopingisfunbutdangerous", "lessdangerousthancoding"), is("abcdefghilnoprstu"));
        assertThat(longest("inmanylanguages", "theresapairoffunctions"), is("acefghilmnoprstuy"));
    }

    private String longest(String firstSentence, String secondSentence) {
        return Stream.of(firstSentence +secondSentence)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(c -> new String(new char[]{(char) c}))) // Hummmmmmmmmm :thinking: :suspicious:
                .distinct()
                .sorted()
                .collect(joining());
    }
}
