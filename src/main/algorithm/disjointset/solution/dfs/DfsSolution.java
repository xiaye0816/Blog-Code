package main.algorithm.disjointset.solution.dfs;

import main.algorithm.disjointset.AbstractDisjointSetSolution;

/**
 * 基于无向图深度优先搜索的解法
 *
 * @author shaoguoqing 2020/12/12
 */
public class DfsSolution extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        // 记录每个人是否被搜索的状态
        int[] seen = new int[friendRelation.length];

        int friendsGroupCount = 0;

        // 遍历每个人，深度优先搜索该人的全部朋友
        for (int i = 0; i < friendRelation.length; i++) {

            // 首次访问到的人，是一个新的朋友圈的起点，记录朋友圈数+1
            if (seen[i] == 0) {
                friendsGroupCount++;

                // 遍历该人的全部朋友圈，记录已访问状态
                dfs(friendRelation, seen, i);
            }

        }

        return friendsGroupCount;

    }

    /**
     * 深度优先搜索朋友圈
     *
     * @param friendRelation 朋友圈关系
     * @param seen           状态记录数组
     * @param i              当前人索引
     */
    public void dfs(int[][] friendRelation, int[] seen, int i) {

        for (int j = 0; j < friendRelation.length; j++) {
            if (friendRelation[i][j] == 1 && seen[j] == 0) {
                seen[j] = 1;

                // 记录搜索当前朋友圈里，朋友的朋友
                dfs(friendRelation, seen, j);
            }
        }

    }
}
