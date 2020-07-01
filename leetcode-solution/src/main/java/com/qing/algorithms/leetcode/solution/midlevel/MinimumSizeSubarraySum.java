package com.qing.algorithms.leetcode.solution.midlevel;

import org.apache.commons.lang3.ArrayUtils;

/**
 * TODO
 * <b>209. 长度最小的子数组</b>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author guoqf
 * @date 2020/6/28 21:54
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if (ArrayUtils.isNotEmpty(nums)) {

            int subFirstIndex=0;

            int subFirstItem = nums[subFirstIndex];

            int subLen = 1;

            if (subFirstItem >= s) {
                return subLen;
            }
            long subSum = subFirstItem;
            int minLen = 0;

            for (int i = 1; i < nums.length; i++) {
                subLen++;
                subSum += nums[i];


            }


        }

        return 0;
    }
}
