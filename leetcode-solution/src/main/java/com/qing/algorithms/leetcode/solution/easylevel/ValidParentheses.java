package com.qing.algorithms.leetcode.solution.easylevel;

import java.util.LinkedList;

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

        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 != 0) {
            return false;
        }

        int charsLen = length >>> 1;
        char[] chars = new char[charsLen];

        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                //左括号
                if (index >= charsLen) {
                    return false;
                }
                chars[index++] = c;
                continue;
            }

            //右括号
            if (index == 0) {
                return false;
            }

            Character openByClose;
            switch (c) {
                case ')':
                    openByClose = '(';
                    break;
                case ']':
                    openByClose ='[';
                    break;
                case '}':
                    openByClose ='{';
                    break;
                default:
                    openByClose = null;
            }
            if (openByClose == null || chars[--index] != openByClose) {
                return false;
            }
        }
        return index == 0;
    }


    public boolean isValidByList(String s) {

        if (s == null) {
            return false;
        }

        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 != 0) {
            return false;
        }

        LinkedList<Character> linkedList = new LinkedList<>();


        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isOpen(c)) {
                linkedList.addLast(c);
                continue;
            }
            if (linkedList.isEmpty()) {
                return false;
            }

            char ch = linkedList.removeLast();
            Character openByClose;
            switch (c) {
                case ')':
                    openByClose = '(';
                    break;
                case ']':
                    openByClose ='[';
                    break;
                case '}':
                    openByClose ='{';
                    break;
                default:
                    openByClose = null;
            }
            if (openByClose == null || ch != openByClose) {
                return false;
            }
        }


        return linkedList.isEmpty();
    }




    private boolean isOpen(char parenthesis) {
        return parenthesis == '(' || parenthesis == '[' || parenthesis == '{';

    }

    private Character getOpenByClose(char close) {
        switch (close) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return null;
        }
    }
}
