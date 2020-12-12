package main.algorithm.disjointset.solution.bruteforce;

import main.algorithm.disjointset.AbstractDisjointSetSolution;
import main.util.MyCollectionsUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The brute force solution
 * @author shaoguoqing 2020/12/11
 */
public class BruteForceSolution extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        List<Set<Integer>> friendGroupList = new ArrayList<>();

        for (int i = 0; i < friendRelation.length; i++) {
            for (int j = i; j < friendRelation.length; j++) {

                if (friendRelation[i][j] == 1) {
                    Set<Integer> newFriendGroup = new HashSet<>();
                    newFriendGroup.add(i);
                    newFriendGroup.add(j);
                    MyCollectionsUtil.combineCrossSet(friendGroupList, newFriendGroup);
                }

            }
        }

        return friendGroupList.size();
    }

}
