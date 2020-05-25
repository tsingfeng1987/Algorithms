package com.qing.algorithms.datastructure.tree.redblack;

import lombok.Data;

import javax.swing.tree.TreeNode;

/**
 * @author guoqf
 * @date 2020/5/21 13:22
 */
@Data
public class RedBlackTree {

    @Data
    public static class TreeNode{

        private TreeNodeColor color;

        private TreeNode parent;

        private TreeNode leftChild;

        private TreeNode rightChild;

        private int value;

    }

    public enum TreeNodeColor{
        /**
         * 红色节点
         */
        RED(0),

        /**
         * 黑色节点
         */
        BLACK(1);

        private int num;

        TreeNodeColor(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}
