package main.algorithm.disjointset;

import main.algorithm.disjointset.solution.bitmap.BitMapSolutionOne;
import main.algorithm.disjointset.solution.bitmap.BitMapSolutionTwo;
import main.algorithm.disjointset.solution.bruteforce.BruteForceSolution;
import main.algorithm.disjointset.solution.dfs.DfsSolution;
import main.algorithm.disjointset.solution.unionfind.UnionFindSolutionOne;
import main.algorithm.disjointset.solution.unionfind.UnionFindSolutionTwo;
import org.junit.Assert;
import org.junit.Test;

/**
 * DisjointSetSolution Test
 *
 * @author shaoguoqing 2020/12/13
 */
public class DisjointSetSolutionTest {

    @Test
    public void bruteForceSolutionTest() {
        doTest(new BruteForceSolution());
    }

    @Test
    public void bitMapSolutionOneTest() {
        doTest(new BitMapSolutionOne());
    }

    @Test
    public void bitMapSolutionTwoTest() {
        doTest(new BitMapSolutionTwo());
    }

    @Test
    public void dfsSolutionTest() {
        doTest(new DfsSolution());
    }

    @Test
    public void unionFindSolutionOneTest() {
        doTest(new UnionFindSolutionOne());
    }

    @Test
    public void unionFindSolutionTwoTest() {
        doTest(new UnionFindSolutionTwo());
    }

    private void doTest(AbstractDisjointSetSolution solution) {

        int[][] friendRelation1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int groupNum1 = solution.findFriendGroupNum(friendRelation1);
        Assert.assertEquals(2, groupNum1);

        int[][] friendRelation2 = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int groupNum2 = solution.findFriendGroupNum(friendRelation2);
        Assert.assertEquals(1, groupNum2);

    }

}
