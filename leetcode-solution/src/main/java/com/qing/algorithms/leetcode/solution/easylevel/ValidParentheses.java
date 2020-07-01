package com.qing.algorithms.leetcode.solution.easylevel;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * @author guoqf
 * @date 2020/7/1 13:24
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        LinkedList<Character> linkedList = new LinkedList<>();

        if (s.isEmpty()) {
            return true;
        }



        for (int i = 0; i < s.length(); i++) {

        }



        return true;
    }


    private Set<Character> openChars = new HashSet<>(4);
    {
        openChars.add('(');
        openChars.add('{');
        openChars.add('[');

    }

//    private Map<Character,Character>
    private boolean isOpen(Character parenthesis) {

        return false;
    }
}
