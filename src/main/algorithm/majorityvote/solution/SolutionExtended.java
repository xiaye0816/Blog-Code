package main.algorithm.majorityvote.solution;

import main.algorithm.majorityvote.AbstractFindMajoritySolution;

/**
 * @author ShaoGuoQing   2019/4/5
 */
public class SolutionExtended extends AbstractFindMajoritySolution {

    @Override
    public Integer findMajority(final int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        int num1 = 0;
        int num1Count = 0;

        int num2 = 0;
        int num2Count = 0;

        for (int item : array) {

            if (num1Count == 0) {
                num1 = item;
            } else if (num2Count == 0) {
                num2 = item;
            }

            if (item == num1) {
                num1Count++;
            } else if (item == num2) {
                num2Count++;
            } else {
                num1Count--;
                num2Count--;
            }
        }

        int count1 = numCountsInArray(array, num1);
        if (count1 > array.length / 3) {
            return num1;
        }

        int count2 = numCountsInArray(array, num2);
        if (count2 > array.length / 3) {
            return num2;
        }

        return null;
    }
}
