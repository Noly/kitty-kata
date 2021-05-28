package codewars;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class chainableNumbers {

//    Given a set of four digit numbers, and two numbers A and B which are in the set, indicate if A and B are chainable.
//    Any numbers X and Y are chainable if the last two digits of X are the first two digits of Y, with any number of chainable numbers in between.
//    For example, given the set {8363, 6388, 8183, 5364, 8353, 8365, 9380}, A=8183, B=6388, yes, A and B are chainable (as [8183, 8363, 6388]).

    @Test
    public void should_return_if_two_numbers_are_chainable() {
        var numbers =new int[]{8363, 6388, 8183, 5364, 8353, 8365, 9380};

        var isChainable = isChainable(8183, 6388, numbers);

        assertThat(isChainable, is(true));

        isChainable = isChainable(5364, 9380, numbers);

        assertThat(isChainable, is(false));
    }

    private boolean isChainable(int first, int last, int[] set) {
        var queue = new LinkedList<String>();
        queue.add(String.valueOf(first));

        while (!queue.isEmpty()){
            var current = queue.removeFirst();
            if (current.equals(String.valueOf(last))) return true;
            for (int j : set) {
                var valueIn = String.valueOf(j);
                if (current.substring(2).equals(valueIn.substring(0, 2))) queue.add(valueIn);
            }
        }
        return false;
    }
}

