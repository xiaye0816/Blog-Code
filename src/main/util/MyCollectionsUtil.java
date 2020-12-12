package main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 集合工具类
 * @author shaoguoqing 2020/12/12
 */
public class MyCollectionsUtil {

    /**
     * 将新set加入到现有set集合里，产生交叉的多个集合融合成一个集合
     *
     * @param oldSetList the old set list
     * @param newSet     the new set
     */
    public static void combineCrossSet(List<Set<Integer>> oldSetList, Set<Integer> newSet) {

        // 记录和newSet产生交叉的oldSet集合
        List<Set<Integer>> crossSetList = new ArrayList<>();

        for (Set<Integer> oldSet : oldSetList) {

            for (Integer num : newSet) {
                if (oldSet.contains(num)) {
                    crossSetList.add(oldSet);
                    break;
                }
            }

        }

        // 将产生交叉的set，从oldSetList里移除，统一融合到newSet里面去
        for (Set<Integer> crossSet : crossSetList) {
            oldSetList.remove(crossSet);
            newSet.addAll(crossSet);
        }

        // 记录融合后的新set
        oldSetList.add(newSet);
    }

}
