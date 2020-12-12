package main.algorithm.disjointset.solution.unionfind;

import main.algorithm.disjointset.AbstractDisjointSetSolution;

import java.util.Arrays;

/**
 * 基于并查集的解法
 *
 * @author shaoguoqing 2020/12/12
 */
public class UnionFindSolutionOne extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        int length = friendRelation.length;

        // 并查集数组，数组索引是成员序号，数组值是上级节点索引，值为-1代表根节点
        int[] parentSet = new int[length];
        Arrays.fill(parentSet, -1);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (friendRelation[i][j] == 1) {
                    unionSet(parentSet, i, j);
                }
            }
        }

        int res = 0;
        for (int i : parentSet) {
            if (i == -1) {
                res++;
            }
        }

        return res;

    }

    /**
     * 寻找根节点
     *
     * @param parentSet   the parent set
     * @param memberIndex the member index
     * @return the int
     */
    public int findRoot(int[] parentSet, int memberIndex) {

        if (parentSet[memberIndex] == -1) {
            return memberIndex;
        }

        return findRoot(parentSet, parentSet[memberIndex]);
    }

    /**
     * 合并两个根节点
     *
     * @param parentSet    the parent set
     * @param memberIndex1 the member index 1
     * @param memberIndex2 the member index 2
     */
    public void unionSet(int[] parentSet, int memberIndex1, int memberIndex2) {

        int parentIndex1 = findRoot(parentSet, memberIndex1);
        int parentIndex2 = findRoot(parentSet, memberIndex2);

        if (parentIndex1 != parentIndex2) {
            parentSet[parentIndex2] = parentIndex1;
        }

    }
}
