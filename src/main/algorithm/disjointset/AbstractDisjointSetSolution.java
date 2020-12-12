package main.algorithm.disjointset;

/**
 * The Abstract Solution For Disjoint Set.
 * @author shaoguoqing 2020/12/11
 */
public abstract class AbstractDisjointSetSolution {

    /**
     * find friend group num for the given friend relations.
     * @param friendRelation friend relations
     * @return friend group num
     */
    public abstract int findFriendGroupNum(int[][] friendRelation);

}
