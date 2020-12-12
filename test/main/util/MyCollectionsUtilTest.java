package main.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MyCollectionsUtil Test
 *
 * @author shaoguoqing 2020/12/13
 */
public class MyCollectionsUtilTest {

    @Test
    public void combineCrossSetTest() {

        List<Set<Integer>> oldSetList = new ArrayList<>();

        Set<Integer> oldSet1 = new HashSet<>();
        oldSet1.add(1);
        oldSet1.add(2);
        oldSet1.add(3);

        Set<Integer> oldSet2 = new HashSet<>();
        oldSet2.add(4);
        oldSet2.add(5);
        oldSet2.add(6);

        oldSetList.add(oldSet1);
        oldSetList.add(oldSet2);

        Set<Integer> newSet = new HashSet<>();
        newSet.add(7);
        newSet.add(8);
        newSet.add(9);

        MyCollectionsUtil.combineCrossSet(oldSetList, newSet);

        Assert.assertEquals(3, oldSetList.size());

        Set<Integer> newSet2 = new HashSet<>();
        newSet2.add(1);
        newSet2.add(4);
        newSet2.add(7);

        MyCollectionsUtil.combineCrossSet(oldSetList, newSet2);

        Assert.assertEquals(1, oldSetList.size());
        Assert.assertEquals(9, oldSetList.get(0).size());
    }

}
