package main.algorithm.majorityvote.solution;

import main.algorithm.majorityvote.AbstractFindMajoritySolution;

import java.util.Arrays;

/**
 * @author ShaoGuoQing   2019/4/5
 */
public class SolutionOne extends AbstractFindMajoritySolution {

    @Override
    public Integer findMajority(final int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        Arrays.sort(array);

        int length = array.length;

        int num = array[length / 2];
        int count = numCountsInArray(array, num);

        if (count > length / 2) {
            return num;
        } else {
            return null;
        }
    }
}
