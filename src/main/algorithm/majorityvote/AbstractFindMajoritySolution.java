package main.algorithm.majorityvote;

import java.util.Arrays;

/**
 * The type Abstract find majority solution.
 * @author shaoguoqing
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
