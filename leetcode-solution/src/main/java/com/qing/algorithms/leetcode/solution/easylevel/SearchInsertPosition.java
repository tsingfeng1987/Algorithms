package com.qing.algorithms.leetcode.solution.easylevel;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author Guoqingfeng
 * @date 2020/7/6
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        for (int right = nums.length - 1; left <= right; left++, right--) {
            if (target <= nums[left]) {
                return left;
            }

            if (target > nums[right]) {
                return right + 1;
            }

            if (target == nums[right]) {
                return right;
            }

        }

        return left;




    }

    private int searchInsert(int[] nums, int start, int end, int target) {
        int mid = (end + start) / 2;
        if (target == nums[mid]) {
            return target;
        }

        if (target < nums[mid]) {
            return searchInsert(nums, start, mid - 1, target);
        }

        return searchInsert(nums, mid + 1, end, target);
    }
}
