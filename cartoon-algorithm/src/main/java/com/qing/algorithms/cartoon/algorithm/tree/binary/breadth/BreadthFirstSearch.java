package com.qing.algorithms.cartoon.algorithm.tree.binary.breadth;

import com.qing.algorithms.cartoon.algorithm.tree.binary.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class BreadthFirstSearch {


    private static Integer[] createValues() {
        return new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = BinaryTreeNode.createTree(createValues());

        breadthFirstSearch1(tree);
//        breadthSearchTree(tree);

    }

    private static void breadthSearchTree(BinaryTreeNode tree) {

        if (tree == null) {
            return;
        }

        LinkedBlockingDeque<BinaryTreeNode> nodeQueue = new LinkedBlockingDeque<>();
        nodeQueue.offer(tree);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode node = nodeQueue.poll();
            System.out.println(node.getValue());

            if (node.getLeftChild() != null) {
                nodeQueue.offer(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                nodeQueue.offer(node.getRightChild());
            }
        }

    }


    private static void breadthFirstSearch1(BinaryTreeNode node) {
        doBreadthFirstSearch1(Collections.singletonList(node));
    }


    private static void doBreadthFirstSearch1(List<BinaryTreeNode> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return;
        }

        List<BinaryTreeNode> nextList = new ArrayList<>();
        for (BinaryTreeNode node : nodeList) {
            System.out.println(node.getValue());
            if (node.getLeftChild() != null) {
                nextList.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                nextList.add(node.getRightChild());
            }
        }

        if (!nodeList.isEmpty()) {
            doBreadthFirstSearch1(nextList);
        }
    }


}
