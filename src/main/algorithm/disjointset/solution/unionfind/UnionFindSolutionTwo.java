package main.algorithm.disjointset.solution.unionfind;

import main.algorithm.disjointset.AbstractDisjointSetSolution;

import java.util.Arrays;

/**
 * 基于并查集的解法，增加路径压缩和按秩合并的优化
 *
 * @author shaoguoqing 2020/12/13
 */
public class UnionFindSolutionTwo extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        int length = friendRelation.length;

        int[] parentSet = new int[length];
        Arrays.fill(parentSet, -1);

        // 记录根节点深度，初始值是1
        int[] heightSet = new int[length];
        Arrays.fill(heightSet, 1);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (friendRelation[i][j] == 1) {
                    unionSet(parentSet, heightSet, i, j);
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
     * @param parentSet   并查集
     * @param heightSet   节点高度set
     * @param memberIndex 根节点索引
     * @return the int
     */
    public int findRoot(int[] parentSet, int[] heightSet, int memberIndex) {

        if (parentSet[memberIndex] == -1) {
            return memberIndex;
        }

        // 路径压缩优化，每次执行find操作时，将路径上全部节点都直接扁平化指向根节点
        parentSet[memberIndex] = findRoot(parentSet, heightSet, parentSet[memberIndex]);
        heightSet[memberIndex] = 1;
        return parentSet[memberIndex];
    }

    /**
     * 合并两个根节点
     *
     * @param parentSet    并查集
     * @param heightSet    节点高度set
     * @param memberIndex1 根节点1索引
     * @param memberIndex2 根节点2索引
     */
    public void unionSet(int[] parentSet, int[] heightSet, int memberIndex1, int memberIndex2) {

        int parentIndex1 = findRoot(parentSet, heightSet, memberIndex1);
        int parentIndex2 = findRoot(parentSet, heightSet, memberIndex2);

        // 按秩合并优化，总是将更小的树合并到更大的树上，这样不会增加整体的深度
        if (parentIndex1 != parentIndex2) {

            if (heightSet[parentIndex1] > heightSet[parentIndex2]) {
                parentSet[parentIndex2] = parentIndex1;
            } else if (heightSet[parentIndex1] < heightSet[parentIndex2]) {
                parentSet[parentIndex1] = parentIndex2;
            } else {
                parentSet[parentIndex2] = parentIndex1;
                heightSet[parentIndex1]++;
            }


        }

    }
}
