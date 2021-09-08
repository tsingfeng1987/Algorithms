package com.qing.algorithms.leetcode.solution.hardlevel;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author guoqf
 * @date 2020/7/3 17:34
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedianOfOfSortedArray(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return findMedianOfOfSortedArray(nums1);
        }

        int newLen = nums1.length + nums2.length;

        int[] newNums = new int[newLen];
        int index1 = 0;
        int index2 = 0;
        int newIndex = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                newNums[newIndex++] = nums1[index1++];
            } else {
                newNums[newIndex++] = nums2[index2++];
            }
        }

        if (index1 < nums1.length) {
            for (int i = newIndex; i < newLen; i++) {
                newNums[i] = nums1[index1++];
            }
        } else {
            for (int i = newIndex; i < newLen; i++) {
                newNums[i] = nums2[index2++];
            }
        }

        return findMedianOfOfSortedArray(newNums);
    }

    private double findMedianOfOfSortedArray(int[] nums) {
        int length = nums.length;
        if (length % 2 == 1) {
            return nums[length / 2];
        } else {
            int divLen = length / 2;
            return ((double)(nums[divLen - 1] + nums[divLen])) / 2;
        }
    }


    public double findMedianSortedArraysByHalf(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedianOfOfSortedArrayWithActualNums(nums2,nums2.length);
        }

        if (nums2 == null || nums2.length == 0) {
            return findMedianOfOfSortedArrayWithActualNums(nums1, nums1.length);
        }

        int totalLen = nums1.length + nums2.length;
        int newLen = totalLen / 2 + 1;
        int[] newNums = new int[newLen];
        int index1 = 0;
        int index2 = 0;
        int newIndex = 0;

        while (index1 < nums1.length && index2 < nums2.length && newIndex < newLen) {
            if (nums1[index1] < nums2[index2]) {
                newNums[newIndex++] = nums1[index1++];
            } else {
                newNums[newIndex++] = nums2[index2++];
            }
        }

        if (newIndex < newLen) {

            if (index1 < nums1.length) {
                for (int i = newIndex; i < newLen; i++) {
                    newNums[i] = nums1[index1++];
                }
            } else {
                for (int i = newIndex; i < newLen; i++) {
                    newNums[i] = nums2[index2++];
                }
            }
        }

        return findMedianOfOfSortedArrayWithActualNums(newNums,totalLen);
    }



    private double findMedianOfOfSortedArrayWithActualNums(int[] nums,int totalLen) {
        if (totalLen % 2 == 1) {
            return nums[totalLen / 2];
        } else {
            int divLen = totalLen / 2;
            return ((double)(nums[divLen - 1] + nums[divLen])) / 2;
        }
    }


}
