package com.qing.algorithms.leetcode.solution.midlevel;

import java.util.Arrays;

/**
 *
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author Guoqingfeng
 * @date 2020/7/5
 */
public class Closest3Nums {
    public int threeSumClosest(int[] nums, int target) {
        int minusSum = 20000;
        int instance = minusSum;

        int iLen = nums.length - 2;

        Arrays.sort(nums);

        for (int first = 0; first < iLen && instance > 0; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                //第一个值重复
                continue;
            }
            for (int second = first + 1, third = nums.length - 1; second < third; ) {

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    //第二个值重复
                    continue;
                }

                int sum = nums[first] + nums[second] + nums[third];

                //匹配到target
                if (sum == target) {
                    minusSum = target;
                    instance = 0;
                    break;
                }

                //和小于target
                if (sum < target) {
                    int inst = target - sum;
                    if (inst < instance) {
                        minusSum=sum;
                        instance = inst;
                    }
                    second++;
                    continue;
                }


                //和大于target
                int inst = sum - target;
                if (inst < instance) {
                    minusSum=sum;
                    instance = inst;
                }
                do {
                    third--;
                } while (second < third && nums[third] == nums[third + 1]);

            }
        }

        return minusSum;
    }



    public int threeSumClosestBase(int[] nums, int target) {
        int minusSum = 20000;
        int instance = minusSum;

        int iLen = nums.length - 2;

        Arrays.sort(nums);

        for (int first = 0; first < iLen; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length-1; second++) {


                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                for (int third = nums.length - 1; third > second; third--) {
                    if (third < nums.length - 1 && nums[third] == nums[third + 1]) {
                        continue;
                    }

                    int sum = nums[first] + nums[second] + nums[third];

                    //匹配到target
                    if (sum == target) {
                        return sum;
                    }

                    //和小于target
                    if (sum < target) {
                        int inst = target - sum;
                        if (inst < instance) {
                            minusSum = sum;
                            instance = inst;
                        }
                        break;
                    }

                    int inst = sum - target;
                    if (inst < instance) {
                        minusSum = sum;
                        instance = inst;
                    }


                }
            }
        }

        return minusSum;
    }
}
