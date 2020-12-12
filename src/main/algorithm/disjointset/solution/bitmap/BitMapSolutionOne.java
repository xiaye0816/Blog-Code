package main.algorithm.disjointset.solution.bitmap;

import main.algorithm.disjointset.AbstractDisjointSetSolution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于BitMap的解法
 * 注意：基于long类型存储bitmap，所以最大支持8字节 = 64个单位（也就是64个学生，超出的话数字会溢出，导致错误结果）
 *
 * 本解法只是展示一个思路，这个解法在力扣原题上是无法AC的，因为N的最大值是200：1 <= N <= 200，部分case会溢出
 * 不溢出的bitmap解法可以参照BitMapSolutionTwo.java
 *
 * @author shaoguoqing 2020/12/12
 */
public class BitMapSolutionOne extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        Set<Long> friendsGroupSet = new HashSet<>();

        for (int i = 0; i < friendRelation.length; i++) {
            for (int j = i; j < friendRelation.length; j++) {

                if (friendRelation[i][j] == 1) {

                    // 使用新的long数字，存储新的朋友圈关系
                    long newFriendsGroup = 0;
                    newFriendsGroup += (1L << i);

                    // 判断是否是一个人的朋友圈的情况
                    if (i != j) {
                        newFriendsGroup += (1L << j);
                    }

                    // 遍历现有朋友圈
                    Iterator<Long> iterator = friendsGroupSet.iterator();

                    while (iterator.hasNext()) {

                        long friendsGroup = iterator.next();

                        // 使用与操作，判断两个朋友圈是否相交，相交的话，剔除原有朋友圈，融合到新朋友圈
                        if ((newFriendsGroup & friendsGroup) > 0) {
                            iterator.remove();
                            // 使用或操作，进行朋友圈融合
                            newFriendsGroup = (newFriendsGroup | friendsGroup);
                        }
                    }

                    // 将融合后的新朋友圈，加入结果集
                    friendsGroupSet.add(newFriendsGroup);
                }

            }
        }

        return friendsGroupSet.size();

    }

}
