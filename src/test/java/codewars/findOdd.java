package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class findOdd {

    /*
        Given an array of integers, find the one that appears an odd number of times.
        There will always be only one integer that appears an odd number of times.
    */

    @Test
    void odd() {
        assertThat(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}), is(5));
        assertThat(findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}), is(-1));
        assertThat(findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}), is(5));
        assertThat(findIt(new int[]{10}), is(10));
        assertThat(findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}), is(10));
        assertThat(findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}), is(1));
    }

    private int findIt(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() % 2 != 0)
                .findFirst()
                .get()
                .getKey();
    }
}
