package main.algorithm.majorityvote;

import main.algorithm.majorityvote.solution.SolutionTwo;
import org.junit.Assert;
import org.junit.Test;

import main.algorithm.majorityvote.solution.SolutionOne;
import main.algorithm.majorityvote.solution.SolutionThree;

/**
 * @author ShaoGuoQing   2019/4/6
 */
public class TestFindMajorityBeyondOneHalfSolution {

    int[] array1 = {3, 2, 3};
    int[] array2 = {2, 2, 1, 1, 1, 2, 2};
    int[] array3 = {1, 2, 3, 4, 5, 6};
    int[] array4 = {1, 1, 1, 2, 2, 2};

    Integer target1 = 3;
    Integer target2 = 2;
    Integer target3 = null;
    Integer target4 = null;

    @Test
    public void testSolutionOne() {
        doTest(new SolutionOne());
    }

    @Test
    public void testSolutionTwo() {
        doTest(new SolutionTwo());
    }

    @Test
    public void testSolutionThree() {
        doTest(new SolutionThree());
    }

    private void doTest(AbstractFindMajoritySolution solution) {

        Integer res1 = solution.findMajority(array1);
        Integer res2 = solution.findMajority(array2);
        Integer res3 = solution.findMajority(array3);
        Integer res4 = solution.findMajority(array4);

        Assert.assertEquals(target1, res1);
        Assert.assertEquals(target2, res2);
        Assert.assertEquals(target3, res3);
        Assert.assertEquals(target4, res4);

    }

}
