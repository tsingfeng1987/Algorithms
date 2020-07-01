package com.qing.algorithms.leetcode.solution.easylevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author guoqf
 * @date 2020/7/1 12:35
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String emptyStr = "";

        int arrLength;
        if (strs == null || (arrLength = strs.length) == 0) {
            return emptyStr;
        }

        if (arrLength == 1) {
            return strs[0];
        }



        int leastLen = strs[0].length();

        for (int i = 1; i < arrLength; i++) {
            int length = strs[i].length();
            if (length < leastLen) {
                leastLen = length;
            }
        }

        char curChar;

        int endIndex = 0;


        boolean hasCommon = true;
        while (hasCommon && endIndex < leastLen) {
            curChar = strs[0].charAt(endIndex);
            for (int i = 1; i < arrLength; i++) {
                if (strs[i].charAt(endIndex) != curChar) {
                    hasCommon = false;
                    break;
                }
            }
            if (hasCommon) {
                endIndex++;
            }

        }

        if (endIndex > 0) {
            return strs[0].substring(0, endIndex);
        }

        return emptyStr;
    }


}
