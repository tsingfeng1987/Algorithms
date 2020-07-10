package com.qing.algorithms.leetcode.solution.easylevel;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * @author guoqf
 * @date 2020/7/8 13:20
 */
public class DivingBoardLcci {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (longer == shorter) {
            return new int[]{shorter * k};
        }
        int len = k + 1;
        int[] result = new int[len];
        int minus = longer - shorter;
        int left=0;
        int right = len - 1;
        int leftVal = shorter * k;
        int rightVal = longer * k;
        while (left <= right) {
            result[left++] = leftVal;
            result[right--] = rightVal;
            leftVal += minus;
            rightVal -= minus;

        }

        return result;

    }
}
