package codewars;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class populationGrowth {

    /*
     In a small town the population is p0 = 1000 at the beginning of a year.
     The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town.
     How many years does the town need to see its population greater or equal to p = 1200 inhabitants?
    */

    @Test
    void should_return_how_many_years_population_will_growth_to_wanted() {
        var expected = yearGrowthCalculator(1000, 2, 50, 1200);
        assertThat(expected, is(3));

        expected = yearGrowthCalculator(1500, 5, 100, 5000);
        assertThat(expected, is(15));

        expected = yearGrowthCalculator(1500000, 2.5f, 10000, 2000000);
        assertThat(expected, is(10));
    }

    // next: validate positive values.

    private int yearGrowthCalculator(final int baseline, final float percentage, final int growthQuantityPerYear, final int desiredPopulation) {
        var acumulated = baseline;
        var years = 0;
        var percent = percentage/100;
        while (acumulated < desiredPopulation) {
            acumulated += acumulated * percent + growthQuantityPerYear;
            years++;
        }
        return years;
    }
}
