package main.majority_vote_algorithm.solution;

import java.util.Arrays;

import main.majority_vote_algorithm.AbstractFindMajoritySolution;

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
