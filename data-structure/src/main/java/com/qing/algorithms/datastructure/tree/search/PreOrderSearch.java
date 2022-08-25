package com.qing.algorithms.datastructure.tree.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;

public class PreOrderSearch {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node{
        private int value;

        private Node left;

        private Node right;
    }

    public static void main(String[] args) {
        Node root = initBinaryTree();
        preOrderSearch(root);
        midOrderSearch(root);
    }

    private static void preOrderSearch(Node root) {
        System.out.println("前序遍历：");
        Node curNode = root;
        ArrayDeque<Node> stack = new ArrayDeque<>();

        while (true) {
            if (curNode == null) {
                Node lastNode = stack.pollLast();
                if (lastNode == null) {
                    break;
                }
                curNode = lastNode.right;
                continue;
            }

            System.out.print(curNode.value + ", ");
            stack.offerLast(curNode);
            curNode = curNode.left;

        }
        System.out.println();
    }

    private static void midOrderSearch(Node root) {
        System.out.println("中序遍历：");
        Node curNode = root;
        ArrayDeque<Node> stack = new ArrayDeque<>();

        while (true) {
            if (curNode == null) {
                curNode = stack.pollLast();
                if (curNode == null) {
                    break;
                }
                System.out.print(curNode.value + ", ");
                curNode = curNode.right;
                continue;
            }


            stack.offerLast(curNode);
            curNode = curNode.left;

        }
        System.out.println();
    }


    private static void postOrderSearch(Node root) {
        System.out.println("后序遍历：");
        Node curNode = root;
        ArrayDeque<Node> stack = new ArrayDeque<>();

        while (true) {
            if (curNode == null) {
                curNode = stack.peekLast();
                if (curNode == null) {
                    break;
                }
                if (curNode.right == null) {
                    System.out.print(curNode.value + ", ");
                    stack.pollLast();
                }
                curNode = curNode.right;

                continue;
            }


            stack.offerLast(curNode);
            curNode = curNode.left;

        }
        System.out.println();
    }

    private static Node initBinaryTree() {
        Node n4 = new Node(4, null, null);

        Node n5 = new Node(5, null, null);

        Node n6 = new Node(6, null, null);

        Node n2 = new Node(2, n4, n5);

        Node n3 = new Node(3, null, n6);

        Node n1 = new Node(1, n2, n3);

        return n1;
    }
}
