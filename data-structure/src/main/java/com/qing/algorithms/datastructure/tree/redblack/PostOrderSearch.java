package com.qing.algorithms.datastructure.tree.redblack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;

/**
 * @author guoqf
 * @date 2022/8/26 13:55
 */
public class PostOrderSearch {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node{
        private int value;

        private Node left;

        private Node right;
    }

    public static void main(String[] args) {
        postOrderSearch(initNode());
    }

    private static void postOrderSearch(Node root) {
        System.out.println("后序遍历：");
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.offerLast(root);
        Node curNode = root;
        Node lastNode = null;
        while (true) {
            if (curNode == null) {
                Node node = stack.peekLast();
                if (node == null) {
                    break;
                }

                if (node.left == lastNode || node.right == lastNode) {
                    System.out.print(node.value + ", ");
                    stack.pollLast();
                    lastNode = node;
                    continue;
                }

                curNode = node;
            }

            lastNode = curNode;

            if (curNode.left == null && curNode.right == null) {
                System.out.print(curNode.value + ", ");
                stack.pollLast();
                curNode = null;
                continue;
            }


            if (curNode.right != null) {
                stack.offerLast(curNode.right);
            }

            if (curNode.left != null) {
                stack.offerLast(curNode.left);
                curNode = curNode.left;
            }else {
                curNode = curNode.right;
            }

        }
    }

    private static Node initNode() {
        Node n6 = new Node(6, null, null);
        Node n3 = new Node(3, null, n6);

        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, null, null);
        Node n2 = new Node(2, n4, n5);

        return new Node(1, n2, n3);
    }
}
