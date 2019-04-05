package main.majority_vote_algorithm.solution;

import main.majority_vote_algorithm.AbstractFindMajoritySolution;

/**
 * @author ShaoGuoQing   2019/4/5
 */
public class SolutionThree extends AbstractFindMajoritySolution {

    @Override
    public Integer findMajority(final int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        int num = 0;
        int numCount = 0;

        for (int item : array) {

            if (numCount == 0) {
                num = item;
            }

            if (num == item) {
                numCount++;
            } else {
                numCount--;
            }
        }

        int count = numCountsInArray(array, num);

        if (count > array.length / 2) {
            return num;
        } else {
            return null;
        }
    }
}
