package com.qing.algorithms.leetcode.solution.easylevel;


/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author guoqf
 * @date 2020/7/2 12:40
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }

        ListNode curLess;
        ListNode curGreater;

        if (l1.val <= l2.val) {
            curLess = l1;
            curGreater = l2;
        } else {
            curLess = l2;
            curGreater = l1;
        }
        ListNode newNode = curLess;
        while (true) {
            ListNode lessNext;
            lessNext = curLess.next;
            if (lessNext == null || curGreater == null) {
                break;
            }

            if (curGreater.val < lessNext.val) {
                curLess.next = curGreater;
                curGreater = curGreater.next;
                curLess.next.next = lessNext;
            }
            curLess = curLess.next;

        }

        if (curGreater != null) {
            curLess.next = curGreater;
        }


        return newNode;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
