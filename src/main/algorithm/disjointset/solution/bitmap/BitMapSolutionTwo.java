package main.algorithm.disjointset.solution.bitmap;

import main.algorithm.disjointset.AbstractDisjointSetSolution;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于BitMap的解法
 * 通过BigInteger存储bitmap，避免了long类型的溢出问题
 *
 * @author shaoguoqing 2020/12/12
 */
public class BitMapSolutionTwo extends AbstractDisjointSetSolution {

    @Override
    public int findFriendGroupNum(int[][] friendRelation) {

        Set<BigInteger> friendsGroupSet = new HashSet<>();

        for (int i = 0; i < friendRelation.length; i++) {
            for (int j = i; j < friendRelation.length; j++) {

                if (friendRelation[i][j] == 1) {

                    BigInteger newFriendsGroup = new BigInteger("1").shiftLeft(i);

                    if (i != j) {
                        newFriendsGroup = newFriendsGroup.add(new BigInteger("1").shiftLeft(j));
                    }

                    Iterator<BigInteger> iterator = friendsGroupSet.iterator();

                    while (iterator.hasNext()) {

                        BigInteger friendsGroup = iterator.next();

                        if ((newFriendsGroup.and(friendsGroup)).compareTo(new BigInteger("0")) > 0) {
                            iterator.remove();
                            newFriendsGroup = newFriendsGroup.or(friendsGroup);
                        }
                    }

                    friendsGroupSet.add(newFriendsGroup);
                }

            }
        }

        return friendsGroupSet.size();
    }

}
