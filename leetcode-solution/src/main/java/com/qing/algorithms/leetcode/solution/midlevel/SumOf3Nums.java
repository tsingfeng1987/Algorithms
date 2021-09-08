package com.qing.algorithms.leetcode.solution.midlevel;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author Guoqingfeng
 * @date 2020/7/5
 */
public class SumOf3Nums {

    public List<List<Integer>> threeSum(int[] nums) {
        //排序+双层循环+双指针的方式

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        int iLen = nums.length - 2;

        Arrays.sort(nums);



        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < iLen; i++) {
            int iValue = nums[i];

            if (i > 0 && iValue == nums[i - 1]) {
                continue;
            }
            int expectValue = -iValue;
            for (int start = i + 1, end = nums.length - 1; start < end; start++) {

                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    continue;
                }

                while (start < end && nums[start] + nums[end] > expectValue) {
                    end--;
                }

                if (start == end || nums[start] + nums[end] < expectValue) {
                    break;
                }

                //双指针查找
                List<Integer> integers = new ArrayList<>(3);
                integers.add(iValue);
                integers.add(nums[start]);
                integers.add(nums[end]);
                //存储结果
                result.addLast(integers);

            }

        }


        return result;

    }


}

