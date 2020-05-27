package com.qing.algorithms.datastructure.tree.redblack;

import lombok.Data;

/**
 * @author guoqf
 * @date 2020/5/21 13:22
 */
@Data
public class RedBlackTree {

    private TreeNode root;

    /**
     * Before:
     *       N
     *    /    \
     *   LN    RN
     *        /  \
     *       RLN  RRN
     *
     * After
     *        RN
     *      /   \
     *     N     RRN
     *   /  \
     *  LN   RLN
     *
     *  N、N.parent、N.rightChild、 N.rightChild.leftChild
     * @param treeNode 待左旋节点
     */
    public void leftRotate(TreeNode treeNode) {
        //获取右子节点
        TreeNode rNode = treeNode.rightChild;

        //右子节点的左子节点作为其右子节点
        treeNode.rightChild = treeNode.rightChild.leftChild;

        if (treeNode.rightChild != null) {
            treeNode.rightChild.parent = treeNode;
        }

        //旋转节点的父节点作为右子节点的父节点
        rNode.parent = treeNode.parent;
        if (rNode.parent == null) {
            //旋转节点为根节点
            this.root = rNode;
        } else {
            if (treeNode == rNode.parent.leftChild) {
                //旋转节点为其父节点的左子节点
                rNode.parent.leftChild = rNode;
            } else {
                //旋转节点为其父节点的右子节点
                rNode.parent.rightChild = rNode;
            }
        }

        //旋转节点变为右子节点的左子节点
        rNode.leftChild = treeNode;

        //右子节点变为旋转节点的父节点
        treeNode.parent = rNode;

    }

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
