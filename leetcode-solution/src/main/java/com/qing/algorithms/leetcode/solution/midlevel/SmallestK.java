package com.qing.algorithms.leetcode.solution.midlevel;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Guoqingfeng
 * @date 2020/7/19
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length <= k) {
            return arr;
        }

        if (k == 0) {
            return new int[0];
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            treeSet.add(arr[i]);
        }


        for (int i = k; i < arr.length; i++) {
            Integer last = treeSet.last();
            int ele = arr[i];
            if (ele < last) {
                treeSet.pollLast();
                treeSet.add(ele);
            }
        }

        Iterator<Integer> iterator = treeSet.iterator();
        int[] result = new int[treeSet.size()];
        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }

        return result;
    }
}
