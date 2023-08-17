package com.qing.algorithms.cartoon.algorithm.tree.binary;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author guoqf
 */
@Data
public class BinaryTreeNode {

    private int value;



    private BinaryTreeNode leftChild;


    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public static BinaryTreeNode createTree(Integer[] values) {
        LinkedList<Integer> valueList = new LinkedList<>(Arrays.stream(values).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        System.out.println("ValueList: ");
        System.out.println(valueList);
        return doCreateTree(valueList);
    }

    private static BinaryTreeNode doCreateTree(LinkedList<Integer> valueList) {
        if (valueList == null || valueList.isEmpty()) {
            return null;
        }

        Integer value = valueList.removeFirst();
        if (value != null) {
            BinaryTreeNode node = new BinaryTreeNode(value);
            node.leftChild = doCreateTree(valueList);
            node.rightChild = doCreateTree(valueList);
            return node;
        }

        return null;

    }
}
