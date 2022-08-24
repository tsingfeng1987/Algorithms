package com.qing.algorithms.leetcode.solution.easylevel;

/**
 * @author Guoqingfeng
 * @date 2020/7/11
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String s = String.valueOf(x);

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (right > left) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
