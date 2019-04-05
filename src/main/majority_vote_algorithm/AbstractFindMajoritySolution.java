package main.majority_vote_algorithm;

import java.util.Arrays;

/**
 * @author shaoguoqing
 * The type Abstract find majority solution.
 */
public abstract class AbstractFindMajoritySolution {

    /**
     * Find majority integer.
     *
     * @param array the array
     * @return the integer
     */
    public abstract Integer findMajority(int[] array);

    /**
     * Num counts in array int.
     *
     * @param array the array
     * @param num   the num
     * @return the int
     */
    protected int numCountsInArray(int[] array, int num) {

        if (array == null) {
            return 0;
        }

        return (int) Arrays.stream(array)
                .filter(item -> item == num)
                .count();
    }
}
