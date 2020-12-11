package main.algorithm.majorityvote.solution;

import main.algorithm.majorityvote.AbstractFindMajoritySolution;

/**
 * @author ShaoGuoQing   2019/4/5
 */
public class SolutionTwo extends AbstractFindMajoritySolution {

    @Override
    public Integer findMajority(final int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        int num = 0;

        int bitSum;
        int bit;

        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {

            bitSum = 0;

            for (int item : array) {
                bitSum += (item >> bitIndex) & 1;
            }

            if (bitSum > array.length / 2) {
                bit = 1;
            } else {
                bit = 0;
            }

            if (bit == 1) {
                num |= (bit << bitIndex);
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
